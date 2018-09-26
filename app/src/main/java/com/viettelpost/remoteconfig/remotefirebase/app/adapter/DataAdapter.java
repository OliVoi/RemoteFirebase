package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.BindHolderData;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapterViewHoder> {

    private static Context context;
    private ArrayList<Conditions> conditionaValues;
    private static ArrayList<parameters> data;

    public DataAdapter(ArrayList<parameters> parameters, Context context, ArrayList<Conditions> con) {
        this.data = parameters;
        this.context = context;
        this.conditionaValues = con;
    }

    @NonNull
    @Override
    public DataAdapterViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.layout_custom, viewGroup, false);

        DataAdapterViewHoder viewHolder = new DataAdapterViewHoder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterViewHoder viewHoder, int i) {

        BindHolderData bindHolderData = new BindHolderData(viewHoder.txtTitle, viewHoder.txtDess, viewHoder.txtDefau, viewHoder.recy_child, data, i, context, conditionaValues);
        bindHolderData.getStart();

        viewHoder.clickItemEven(new DataAdapterViewHoder.ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(context, "vị trí: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
