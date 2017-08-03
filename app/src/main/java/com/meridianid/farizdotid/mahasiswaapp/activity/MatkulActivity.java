package com.meridianid.farizdotid.mahasiswaapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.adapter.MatkulAdapter;
import com.meridianid.farizdotid.mahasiswaapp.model.ResponseMatkul;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuamatkulItem;
import com.meridianid.farizdotid.mahasiswaapp.util.api.BaseApiService;
import com.meridianid.farizdotid.mahasiswaapp.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulActivity extends AppCompatActivity {

    @BindView(R.id.btnTambahMatkul)
    Button btnTambahMatkul;
    @BindView(R.id.tvBelumMatkul)
    TextView tvBelumMatkul;
    @BindView(R.id.rvMatkul)
    RecyclerView rvMatkul;
    ProgressDialog loading;

    Context mContext;
    List<SemuamatkulItem> semuamatkulItemList = new ArrayList<>();
    MatkulAdapter matkulAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul);

        getSupportActionBar().setTitle("Mata Kuliah");

        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();
        mContext = this;

        matkulAdapter = new MatkulAdapter(this, semuamatkulItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvMatkul.setLayoutManager(mLayoutManager);
        rvMatkul.setItemAnimator(new DefaultItemAnimator());

        getDataMatkul();

        btnTambahMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MatkulActivity.this, TambahMatkulActivity.class));
            }
        });
    }

    private void getDataMatkul(){
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaMatkul().enqueue(new Callback<ResponseMatkul>() {
            @Override
            public void onResponse(Call<ResponseMatkul> call, Response<ResponseMatkul> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    if (response.body().isError()) {
                        tvBelumMatkul.setVisibility(View.VISIBLE);
                    } else {
                        final List<SemuamatkulItem> semuamatkulItems = response.body().getSemuamatkul();
                        rvMatkul.setAdapter(new MatkulAdapter(mContext, semuamatkulItems));
                        matkulAdapter.notifyDataSetChanged();
                    }
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data mata kuliah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMatkul> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
