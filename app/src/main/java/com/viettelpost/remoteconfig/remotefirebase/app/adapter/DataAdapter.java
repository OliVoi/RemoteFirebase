package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
    private ArrayList<String> conditionaValues;
    DemoAdapter demoAdapter;
    private CallBackData callBackData;

    public DataAdapter(ArrayList<parameters> parameters, Context context) {
        this.data = parameters;
        this.context = context;
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
        RecyclerView lists = viewHoder.re;


        GetData d = GetData.CallGetData(context);
        String a = "";
        txttitle.setText(data.get(i).getTitle());
        txtdefau.setText(data.get(i).getDescription());

//        callBackData.onClickItem(i);

        conditionaValues = new ArrayList<String>();

//        for(int e = 0 ; e < data.get(i).getConditionalValues().size(); e++){
//            if(data.get(i).getConditionalValues().get(e).getKey().equals("")){
//                Log.e("vaoday", "vao");
//                conditionaValues.clear();
//            }
//            else {
//                Log.e("kiemtra", data.get(i).getConditionalValues().get(e).getValue());
//            }
//
//        }

        Log.e("chieudai", String.valueOf(data.get(i).getConditionalValues().size()));

        if(data.get(i).getConditionalValues() != null){
            for (int e = 0; e < data.get(i).getConditionalValues().size(); e++) {
                conditionaValues.add(data.get(i).getConditionalValues().get(e).getKey());
            }
            demoAdapter = new DemoAdapter(conditionaValues);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            lists.setLayoutManager(layoutManager);
            lists.setAdapter(demoAdapter);
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
        public RecyclerView re;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDess = itemView.findViewById(R.id.txt_dess);
            re = itemView.findViewById(R.id.recy_demo);


        }
    }

    public interface CallBackData {
        public void onClickItem(int a);
    }
}
