package com.meridianid.farizdotid.mahasiswaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResultNama;
    String resultNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultNama = extras.getString("result_nama");
            tvResultNama.setText(resultNama);
    }

    private void initComponents(){
        tvResultNama = (TextView) findViewById(R.id.tvResultNama);
    }
}
