package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class ConditionViewHolder extends RecyclerView.ViewHolder {
    public TextView txtKey;
    public TextView txtValue;
    public LinearLayout linLayout;
    public ColorTag colorTag = ColorTag.getColorTag();
    public ArrayList<MyColor> myColors;



    public ConditionViewHolder(View itemView) {
        super(itemView);
        txtKey = (TextView) itemView.findViewById(R.id.txt_key_conditions);
        txtValue = (TextView) itemView.findViewById(R.id.txt_value_conditions);
        linLayout = (LinearLayout) itemView.findViewById(R.id.layout_child);
        myColors = colorTag.dataColor();


    }

}
