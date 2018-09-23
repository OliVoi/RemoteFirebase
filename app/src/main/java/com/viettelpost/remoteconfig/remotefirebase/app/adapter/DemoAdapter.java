package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.RecyclerViewHolder> {
    private List<ConditionaValues> data = new ArrayList<>();

    public DemoAdapter(List<ConditionaValues> data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_conditions, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.txtKey.setText(data.get(position).getKey());
        holder.txtValue.setText(data.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtKey;
        TextView txtValue;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtKey = (TextView) itemView.findViewById(R.id.txt_key_conditions);
            txtValue = (TextView) itemView.findViewById(R.id.txt_value_conditions);
        }
    }
}
