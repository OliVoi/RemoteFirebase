package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.app.adapter.ConditionAdapter;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;

public class BindHolderData {
    private TextView txttitle, txtdess, txt_defau;
    private RecyclerView rec_child;
    private ArrayList<parameters>  data;
    private int i;
    private Context context;
    private ArrayList<Conditions> conditionaValues;

    public BindHolderData(TextView txttitle, TextView txtDess, TextView txt_defau, RecyclerView rec_child, ArrayList<parameters> data, int i, Context context, ArrayList<Conditions> conditionaValues) {
        this.txttitle = txttitle;
        this.txtdess = txtDess;
        this.txt_defau = txt_defau;
        this.rec_child = rec_child;
        this.data = data;
        this.i = i;
        this.context = context;
        this.conditionaValues = conditionaValues;
    }

    public void getStart() {
        if (data.get(i).getTitle() != null) {
            txttitle.setText(data.get(i).getTitle());
            txtdess.setText(data.get(i).getDescription());
        }


        if (data.get(i).getDefaultValue().length() != 0) {
            txt_defau.setTextColor(Color.parseColor("#777777"));
            txt_defau.setText(data.get(i).getDefaultValue());
        }

        if (data.get(i).getDefaultValue().length() == 0) {
            txt_defau.setTextColor(Color.parseColor("#ff0000"));
            txt_defau.setText("Không có giá trị");
        }

        if (data.get(i).getConditionalValues().size() != 0) {
            Log.e("uiuiuiuiu", String.valueOf(data.get(i).getConditionalValues().size()));
            ConditionAdapter adapter = new ConditionAdapter(data.get(i).getConditionalValues(), context, conditionaValues);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rec_child.setLayoutManager(layoutManager);
            rec_child.setAdapter(adapter);
        } else {
            rec_child.setLayoutManager(null);
            rec_child.setAdapter(null);
        }

    }


}
