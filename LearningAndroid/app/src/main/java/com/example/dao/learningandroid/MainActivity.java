package com.example.dao.learningandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button btnTextEditActivity;
    Button btnCheckboxActivity;
    Button btnImageActivity;
    Button btnListviewActivity;
    Button btnListViewDynamicActivity;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.example.dao.learningandroid.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }

    void addControls() {
        btnTextEditActivity = (Button) findViewById(R.id.btnTextEdit);
        btnCheckboxActivity = (Button) findViewById(R.id.btnCheckboxActivity);
        btnImageActivity = (Button) findViewById(R.id.btnImageActivity);
        btnListviewActivity = (Button) findViewById(R.id.btnListViewActivity);
        btnListViewDynamicActivity = (Button) findViewById(R.id.btnListViewDynamicActivity);
    }

    void addEvents()
    {
        btnTextEditActivity.setOnClickListener(myOnlyhandler);
        btnCheckboxActivity.setOnClickListener(myOnlyhandler);
        btnImageActivity.setOnClickListener(myOnlyhandler);
        btnListviewActivity.setOnClickListener(myOnlyhandler);
        btnListViewDynamicActivity.setOnClickListener(myOnlyhandler);
    }

    View.OnClickListener myOnlyhandler = new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId()) {
                case R.id.btnTextEdit: {
                    Log.d(LOG_TAG, "Button Call_TextActivity clicked!");
                    intent = new Intent(MainActivity.this, TexteditActivity.class);
                }
                break;

                case R.id.btnCheckboxActivity: {
                    Log.d(LOG_TAG, "Button btnCheckboxActivity clicked!");
                    intent = new Intent(MainActivity.this, CheckboxActivity.class);
                }
                break;

                case R.id.btnImageActivity: {
                    Log.d(LOG_TAG, "Button btnImageActivity clicked!");
                    intent = new Intent(MainActivity.this, ImageviewActivity.class);
                }
                break;

                case R.id.btnListViewActivity: {
                    Log.d(LOG_TAG, "Button btnListviewActivity clicked!");
                    intent = new Intent(MainActivity.this, ListviewActivity.class);
                }
                break;


                case R.id.btnListViewDynamicActivity: {
                    Log.d(LOG_TAG, "Button btnListViewDynamicActivity clicked!");
                    intent = new Intent(MainActivity.this, ListViewDynamicActivity.class);
                }
                break;
                default:
                    break;
            }

            intent.putExtra(MainActivity.EXTRA_MESSAGE, "Gui tu main");
            if (intent != null)
                startActivity(intent);
            finish();
        }
    };
}
