package com.meridianid.farizdotid.mahasiswaapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.meridianid.farizdotid.mahasiswaapp.R;
import com.meridianid.farizdotid.mahasiswaapp.model.SemuamatkulItem;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fariz ramadhan.
 * website : www.farizdotid.com
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */


public class MatkulAdapter extends RecyclerView.Adapter<MatkulAdapter.MatkulHolder> {

    Context mContext;
    List<SemuamatkulItem> semuamatkulItemList;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public MatkulAdapter(Context context, List<SemuamatkulItem> matkulList) {
        this.mContext = context;
        semuamatkulItemList = matkulList;
    }

    @Override
    public MatkulAdapter.MatkulHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matkul, parent, false);
        return new MatkulHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MatkulAdapter.MatkulHolder holder, int position) {
        final SemuamatkulItem semuamatkulItem = semuamatkulItemList.get(position);
        holder.tvNamaDosen.setText(semuamatkulItem.getNamaDosen());
        holder.tvNamaMatkul.setText(semuamatkulItem.getMatkul());

        String namaDosen = semuamatkulItem.getNamaDosen();
        String firstCharNamaDosen = namaDosen.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNamaDosen, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return semuamatkulItemList.size();
    }

    public class MatkulHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivTextDrawable)
        ImageView ivTextDrawable;
        @BindView(R.id.tvNamaDosen)
        TextView tvNamaDosen;
        @BindView(R.id.tvNamaMatkul)
        TextView tvNamaMatkul;

        public MatkulHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
