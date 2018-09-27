package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class ChildViewHoder extends RecyclerView.ViewHolder {

        public EditText editConditionValue;
        public TextView txtConditionKey;
        public ColorTag colorTag = ColorTag.getColorTag();
        public ArrayList<MyColor> myColors;

        public ChildViewHoder(@NonNull View itemView) {
            super(itemView);
            editConditionValue = itemView.findViewById(R.id.edit_condition);
            txtConditionKey = itemView.findViewById(R.id.txt_condition);
            myColors = colorTag.dataColor();
        }


    }
