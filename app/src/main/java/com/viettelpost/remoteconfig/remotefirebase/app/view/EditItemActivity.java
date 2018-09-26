package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.DataAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.EditItemAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    private ArrayList<Conditions> conditionaValues;
    private ArrayList<parameters> data;
    private Context context;
    private EditText editTitle, editDess, editDefau;
    private int cusor;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        findId();

        if (data.get(cusor).getTitle().length() != 0) {
            editTitle.setText(data.get(cusor).getTitle());
        }


        if (data.get(cusor).getDescription().length() != 0) {
            editDess.setText(data.get(cusor).getDescription());
        }

        if (data.get(cusor).getDefaultValue().length() != 0) {
            editDefau.setText(data.get(cusor).getDefaultValue());
        }

        if (data.get(cusor).getConditionalValues().size() != 0) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            EditItemAdapter adapter = new EditItemAdapter(data.get(cusor).getConditionalValues(), this, conditionaValues);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } else if (data.get(cusor).getConditionalValues().size() == 0) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
    }

    private void findId() {
        data = (ArrayList<parameters>) getIntent().getSerializableExtra("data");
        cusor = getIntent().getIntExtra("cusor", 0);

        GetData dataa = GetData.CallGetData(this);
        conditionaValues = dataa.showDataConditions();

        editTitle = findViewById(R.id.edit_title);
        editDess = findViewById(R.id.edit_dess);
        editDefau = findViewById(R.id.edit_defau);
        recyclerView = findViewById(R.id.recy_item);
    }
}
