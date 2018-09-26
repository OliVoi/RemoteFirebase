package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class EditItemAdapter extends RecyclerView.Adapter<EditItemAdapter.editViewHoder> {

    private ArrayList<ConditionaValues> dataValue;
    private Context context;

    public EditItemAdapter(ArrayList<ConditionaValues> dataValue, Context context) {
        this.dataValue = dataValue;
        this.context = context;
    }

    @NonNull
    @Override
    public editViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.custom_item_edit, viewGroup, false);
        return new editViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull editViewHoder hoder, int position) {

        if (dataValue.size() != 0) {
            Log.e("lolololoo", dataValue.get(position).getKey());
            Log.e("lolololoo", dataValue.get(position).getValue());
        }
    }


    @Override
    public int getItemCount() {
        if (dataValue.size() != 0) {
            return dataValue.size();
        }
        return 0;
    }

    public class editViewHoder extends RecyclerView.ViewHolder {

        public EditText editConditionValue;
        public TextView txtConditionKey;
        public ColorTag colorTag = ColorTag.getColorTag();
        public ArrayList<MyColor> myColors;

        public editViewHoder(@NonNull View itemView) {
            super(itemView);
            editConditionValue = itemView.findViewById(R.id.edit_condition);
            txtConditionKey = itemView.findViewById(R.id.txt_key_conditions);
            myColors = colorTag.dataColor();
        }
    }
}
