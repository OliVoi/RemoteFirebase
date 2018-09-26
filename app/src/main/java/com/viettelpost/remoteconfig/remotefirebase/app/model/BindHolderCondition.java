package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class BindHolderCondition {
    private ArrayList<ConditionaValues> dataValue;
    private ArrayList<Conditions> dataConditions;
    private GradientDrawable drawable;
    private int position;
    private TextView txtKey, txtValue;
    public ArrayList<MyColor> myColors;
    private LinearLayout linLayout;

    public BindHolderCondition(ArrayList<ConditionaValues> dataValue, ArrayList<Conditions> dataConditions, GradientDrawable drawable, int position, TextView txtKey, TextView txtValue, ArrayList<MyColor> myColors, LinearLayout linLayout) {
        this.dataValue = dataValue;
        this.dataConditions = dataConditions;
        this.drawable = drawable;
        this.position = position;
        this.txtKey = txtKey;
        this.txtValue = txtValue;
        this.myColors = myColors;
        this.linLayout = linLayout;
    }

    public void getStart() {

        if (dataValue.get(position).getKey().length() != 0) {
            for (int i = 0; i < dataConditions.size(); i++) {
                String condition = dataConditions.get(i).getName();
                if (dataValue.get(position).getKey().equals(condition)) {
                    for (int e = 0; e < myColors.size(); e++) {
                        String thisColor = myColors.get(e).getColorName();
                        if (dataConditions.get(i).getTagColor().equals(thisColor)) {
                            drawable = (GradientDrawable) linLayout.getBackground();
                            drawable.setColor(Color.parseColor(myColors.get(e).getColorCode()));
                            txtValue.setTextColor(Color.parseColor(myColors.get(e).getColorCode()));
                            txtKey.setText(dataValue.get(position).getKey());
                        }
                    }
                }
            }
        }
        if (dataValue.get(position).getValue().length() != 0) {
            txtValue.setText(dataValue.get(position).getValue());
        } else if (dataValue.get(position).getValue().length() == 0) {
            txtValue.setText("Không có giá trị");
            txtValue.setTextColor(Color.parseColor("#ff0000"));
        }
    }

}
