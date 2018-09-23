package com.viettelpost.remoteconfig.remotefirebase.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class ConditionAdapter extends RecyclerView.Adapter<ConditionAdapter.RecyclerViewHolder> {
    private ArrayList<ConditionaValues> dataValue;
    private Context context;
    private ArrayList<Conditions> dataConditions;
    private ArrayList<MyColor> myColors;
    private GradientDrawable drawable;

    public ConditionAdapter(ArrayList<ConditionaValues> datav, Context c, ArrayList<Conditions> con) {
        this.dataValue = datav;
        this.context = c;
        this.dataConditions = con;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_conditions, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.txtKey.setText(dataValue.get(position).getKey());
        holder.txtValue.setText(dataValue.get(position).getValue());

        ColorTag colorTag = ColorTag.getColorTag();
        myColors = colorTag.dataColor();


        for (int i = 0; i < dataConditions.size(); i++) {
            String condition = dataConditions.get(i).getName();
            if (dataValue.get(position).getKey().equals(condition)) {
                Log.e("vavavavav", dataValue.get(position).getKey());
                for (int e = 0; e < myColors.size(); e++) {
                    String thisColor = myColors.get(e).getColorName();
                    Log.e("thisColor...", thisColor);
                    if (dataConditions.get(i).getTagColor().equals(thisColor)) {
                        Log.e("nônnonono...", myColors.get(e).getColorName() + " : " + dataValue.get(position).getKey());
                        drawable = (GradientDrawable) holder.linLayout.getBackground();
                        drawable.setColor(Color.parseColor(myColors.get(e).getColorCode()));
                        holder.txtValue.setTextColor(Color.parseColor(myColors.get(e).getColorCode()));
                    }
                }
            }
        }


        Log.e("hjhjhjh", dataValue.get(position).getKey() + " :: " + dataValue.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        if (dataValue.size() != 0) {
            return dataValue.size();
        }
        return 0;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtKey;
        TextView txtValue;
        LinearLayout linLayout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtKey = (TextView) itemView.findViewById(R.id.txt_key_conditions);
            txtValue = (TextView) itemView.findViewById(R.id.txt_value_conditions);
            linLayout = (LinearLayout) itemView.findViewById(R.id.layout_child);
        }
    }
}
