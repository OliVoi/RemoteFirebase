package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.session.MediaSession;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.BindHolderCondition;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class ConditionAdapter extends RecyclerView.Adapter<ConditionViewHolder> {
    private ArrayList<ConditionaValues> dataValue;
    private Context context;
    private ArrayList<Conditions> dataConditions;
    private GradientDrawable drawable;

    public ConditionAdapter(ArrayList<ConditionaValues> datav, Context c, ArrayList<Conditions> con) {
        this.dataValue = datav;
        this.context = c;
        this.dataConditions = con;
    }

    @Override
    public ConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_conditions, parent, false);
        return new ConditionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConditionViewHolder holder, int position) {
        BindHolderCondition holderCondition = new BindHolderCondition(dataValue, dataConditions, drawable, position, holder.txtKey, holder.txtValue, holder.myColors, holder.linLayout);
        holderCondition.getStart();

    }

    @Override
    public int getItemCount() {
        if (dataValue.size() != 0) {
            return dataValue.size();
        }
        return 0;
    }
}
