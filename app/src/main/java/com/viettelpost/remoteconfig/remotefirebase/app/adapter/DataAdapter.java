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

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHoder> {

    private static Context context;
    private ArrayList<Conditions> conditionaValues;
    private static ArrayList<parameters> data;
    private static CallBackData callBackData;

    public DataAdapter(ArrayList<parameters> parameters, Context context, ArrayList<Conditions> con) {
        this.data = parameters;
        this.context = context;
        this.conditionaValues = con;
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
        RecyclerView rec_child = viewHoder.recy_child;
        TextView txt_defau = viewHoder.txtDefau;

        txttitle.setText(data.get(i).getTitle());
        txtdefau.setText(data.get(i).getDescription());

        if (data.get(i).getDefaultValue().length() != 0) {
            txt_defau.setTextColor(Color.parseColor("#777777"));
            txt_defau.setText(data.get(i).getDefaultValue());
        }

        if (data.get(i).getConditionalValues().size() != 0) {
            Log.e("uiuiuiuiu", String.valueOf(data.get(i).getConditionalValues().size()));
            ConditionAdapter adapter = new ConditionAdapter(data.get(i).getConditionalValues(), context, conditionaValues);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rec_child.setLayoutManager(layoutManager);
            rec_child.setAdapter(adapter);
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

        private TextView txtTitle;
        private TextView txtDess;
        private RecyclerView recy_child;
        private TextView txtDefau;


        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDess = itemView.findViewById(R.id.txt_dess);
            txtDefau = itemView.findViewById(R.id.valu_defau);
            recy_child = itemView.findViewById(R.id.recy_child);
        }
    }

    public interface CallBackData {
        public void onClickItem(int a);
    }
}
