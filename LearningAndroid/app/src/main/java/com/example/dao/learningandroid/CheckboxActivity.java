package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    CheckBox checkBoxBuyCar;
    CheckBox checkBoxBuyHouse;
    CheckBox checkBoxBuyIPhone;
    TextView textViewOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        addControls();
        addEvents();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
    void addControls()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         checkBoxBuyCar = (CheckBox)findViewById(R.id.checkBoxBuyCar);
         checkBoxBuyHouse = (CheckBox)findViewById(R.id.checkBoxBuyHouse);
         checkBoxBuyIPhone = (CheckBox)findViewById(R.id.checkBoxBuyIPhone);
        textViewOptions = (TextView) findViewById(R.id.textViewOptions);
    }

    private void showPopup(String string)
    {
        Toast.makeText(CheckboxActivity.this, " Ban chon: " + string, Toast.LENGTH_LONG).show();
    }

    void addEvents()
    {
        checkBoxBuyCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

                if(checkBoxBuyCar.isChecked())
                {
                   showPopup(checkBoxBuyCar.getText().toString());
                }
            }
        });

        checkBoxBuyHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                if(checkBoxBuyHouse.isChecked())
                {
                    showPopup(checkBoxBuyHouse.getText().toString());
                }
            }
        });

        checkBoxBuyIPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                if(checkBoxBuyIPhone.isChecked())
                {
                    showPopup(checkBoxBuyIPhone.getText().toString());
                }
            }
        });
    }

    void doProcess()
    {
        String str = "";
        if(checkBoxBuyHouse.isChecked())
            str += checkBoxBuyHouse.getText().toString() + "\n";

        if(checkBoxBuyCar.isChecked())
            str += checkBoxBuyCar.getText().toString() + "\n";

        if(checkBoxBuyIPhone.isChecked())
            str += checkBoxBuyIPhone.getText().toString();

        textViewOptions.setText(str);

    }

}
