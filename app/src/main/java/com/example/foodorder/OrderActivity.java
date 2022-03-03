package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private Spinner spnMakeChoice;
    private Button  btnSendOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        spnMakeChoice = findViewById(R.id.spnMakeChoice);
        btnSendOrder = findViewById(R.id.btnSendOrder);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Vælg fra listen");
        arrayList.add("Dagens ret");
        arrayList.add("Husets pizza");
        arrayList.add("Pastaret med kylling");
        arrayList.add("3 stk smørrebrød");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(OrderActivity.this, android.R.layout.simple_spinner_item, arrayList);

        spnMakeChoice.setAdapter(adapter);

        btnSendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spnMakeChoice.getSelectedItemPosition() == 0) { Toast.makeText(OrderActivity.this, "Vælg noget fra listen", Toast.LENGTH_SHORT).show(); finish();}
                String order = spnMakeChoice.getSelectedItem().toString();
                Intent intent = getIntent();
                intent.putExtra("order", order);
                setResult(Activity.RESULT_OK, intent);
                finish();
//                Toast.makeText(OrderActivity.this, "Din bestilling: " + order, Toast.LENGTH_SHORT).show();
            }
        });
    }
}