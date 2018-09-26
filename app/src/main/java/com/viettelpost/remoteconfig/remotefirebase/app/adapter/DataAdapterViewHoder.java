package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;

public class DataAdapterViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtTitle;
    public TextView txtDess;
    public RecyclerView recy_child;
    public TextView txtDefau;
    public ImageView btnIcon;
    private ItemClickListener itemClickListener;


    public DataAdapterViewHoder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txt_title);
        txtDess = itemView.findViewById(R.id.txt_dess);
        txtDefau = itemView.findViewById(R.id.valu_defau);
        recy_child = itemView.findViewById(R.id.recy_child);
        btnIcon = itemView.findViewById(R.id.img_icon);
        itemView.setOnClickListener(this);
    }

    public void clickItemEven(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition());
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }
}
