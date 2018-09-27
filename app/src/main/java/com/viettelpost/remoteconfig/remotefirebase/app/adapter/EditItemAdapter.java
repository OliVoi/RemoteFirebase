package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.app.ProgressDialog;
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

public class EditItemAdapter extends RecyclerView.Adapter<ChildViewHoder> {

    private ArrayList<ConditionaValues> dataValue;
    private Context context;
    private ArrayList<Conditions> dataConditions;

    public EditItemAdapter(ArrayList<ConditionaValues> dataValue, Context context, ArrayList<Conditions> con) {
        this.dataValue = dataValue;
        this.context = context;
        this.dataConditions = con;
    }

    @NonNull
    @Override
    public ChildViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.custom_item_edit, viewGroup, false);
        return new ChildViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHoder hoder, int position) {

        if (dataValue.get(position).getKey().length() != 0) {
            for (int i = 0; i < dataConditions.size(); i++) {
                String condition = dataConditions.get(i).getName();
                if (dataValue.get(position).getKey().equals(condition)) {
                    for (int e = 0; e < hoder.myColors.size(); e++) {
                        String thisColor = hoder.myColors.get(e).getColorName();
                        if (dataConditions.get(i).getTagColor().equals(thisColor)) {
                            hoder.editConditionValue.setTextColor(Color.parseColor(hoder.myColors.get(e).getColorCode()));
                            hoder.txtConditionKey.setTextColor(Color.parseColor(hoder.myColors.get(e).getColorCode()));
                            hoder.txtConditionKey.setText(dataValue.get(position).getKey());
                        }
                    }
                }
            }
        }

        if (dataValue.get(position).getValue().length() != 0) {
            hoder.editConditionValue.setText(dataValue.get(position).getValue());
        }
        if (dataValue.get(position).getValue().length() == 0) {
            hoder.editConditionValue.setText(null);
        }

    }

    @Override
    public int getItemCount() {
        if (dataValue.size() != 0) {
            return dataValue.size();
        }
        return 0;
    }
}
