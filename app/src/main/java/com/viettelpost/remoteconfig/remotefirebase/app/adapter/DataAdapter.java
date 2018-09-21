package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHoder> {

    private Context context;
    private ArrayList<parameters> data;
    private Activity activity;
    private CallBackData callBackData;

    public DataAdapter(ArrayList<parameters> parameters, Context context, Activity a, CallBackData c) {
        this.data = parameters;
        this.context = context;
        this.activity = a;
        this.callBackData = c;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layout_custom, viewGroup, false);

        // Return a new holder instance
        ViewHoder viewHolder = new ViewHoder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {


        TextView txttitle = viewHoder.txtTitle;
        TextView txtdefau = viewHoder.txtDess;
        final TextView txtkey = viewHoder.txtKey;
        GetData d = GetData.CallGetData(activity);
        String a = "";
        txttitle.setText(data.get(i).getTitle());
        txtdefau.setText(data.get(i).getDescription());

        callBackData.onClickItem(i);

        for (int o = 0; o < data.get(i).getConditionalValues().size(); o++) {
            a += data.get(i).getConditionalValues().get(o).getKey() + "\n";
            txtkey.setText(a);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDess;
        public TextView txtKey;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDess = itemView.findViewById(R.id.txt_dess);
            txtKey = itemView.findViewById(R.id.txt_key);

            txtKey.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callBackData != null) {
                        callBackData.onClickItem(1);
                    }
                }
            });

        }
    }

    public interface CallBackData {
        public void onClickItem(int a);
    }
}
