package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewHoder> {

    Context context;
    ArrayList<parameters> data;

    public DataAdapter(ArrayList<parameters> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public ArrayList<parameters> getData() {
        return data;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View interView = inflater.inflate(R.layout.layout_custom, viewGroup, false);
        return new viewHoder(interView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder viewHoder, int i) {
        viewHoder.txtTitle.setText(data.get(i).getTitle());
        viewHoder.txtDefau.setText(data.get(i).getDefaultValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDefau;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.textView);
            txtDefau = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
