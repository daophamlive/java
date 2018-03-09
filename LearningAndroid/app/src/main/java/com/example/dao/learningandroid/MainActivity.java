package com.example.dao.learningandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    enum Features{
        TEXT_EDIT,
        CHECKBOX,
        IMAGE,
        LISTVIEW,
        LISTVIEW_DYNAMIC,
        LISTVIEW_ADVANCE,
        GRIDVIEW,
        DATETIME_PICKER,
        KARAOKE,
        LEARNING_ACTIVITY
    };


//    Button btnTextEditActivity;
//    Button btnCheckboxActivity;
//    Button btnImageActivity;
//    Button btnListviewActivity;
//    Button btnListViewDynamicActivity;
//    Button btnListViewAdvancedActivity;
//    Button btnGridView;
//    Button btnDateTimePicker;

    ListView listViewMain;
    ArrayList<String> arrayListMain;
    ArrayAdapter<String> adapterMain;


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
//        btnTextEditActivity = (Button) findViewById(R.id.btnTextEdit);
//        btnCheckboxActivity = (Button) findViewById(R.id.btnCheckboxActivity);
//        btnImageActivity = (Button) findViewById(R.id.btnImageActivity);
//        btnListviewActivity = (Button) findViewById(R.id.btnListViewActivity);
//        btnListViewDynamicActivity = (Button) findViewById(R.id.btnListViewDynamicActivity);
//        btnListViewAdvancedActivity = (Button) findViewById(R.id.btnListViewAdvancedActivity);
//        btnGridView = (Button) findViewById(R.id.btnGridView);
//        btnDateTimePicker = (Button) findViewById(R.id.btnDateTimePicker);



        listViewMain = (ListView) findViewById(R.id.listViewMain);
        arrayListMain = new ArrayList<>();
        for (Features feature : Features.values()) {
            // do what you want
//            Button btn = new Button(this);
//            btn.setText(feature.toString());
            // btn.setOnClickListener(myOnlyhandler);
            arrayListMain.add(feature.toString());
        }

        adapterMain = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListMain);
        listViewMain.setAdapter(adapterMain);
    }

    void addEvents()
    {
//        btnTextEditActivity.setOnClickListener(myOnlyhandler);
//        btnCheckboxActivity.setOnClickListener(myOnlyhandler);
//        btnImageActivity.setOnClickListener(myOnlyhandler);
//        btnListviewActivity.setOnClickListener(myOnlyhandler);
//        btnListViewDynamicActivity.setOnClickListener(myOnlyhandler);
//        btnListViewAdvancedActivity.setOnClickListener(myOnlyhandler);
//        btnGridView.setOnClickListener(myOnlyhandler);
//        btnDateTimePicker.setOnClickListener(myOnlyhandler);

        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Features selectedFeature = Features.values()[position];

                processAction(selectedFeature);
            }
        });


    }

    private void processAction(Features selectedFeature) {

        Intent intent = null;
        switch (selectedFeature)
        {
            case TEXT_EDIT: {
                Log.d(LOG_TAG, "Button Call_TextActivity clicked!");
                intent = new Intent(MainActivity.this, TexteditActivity.class);
            }
            break;

            case CHECKBOX: {
                Log.d(LOG_TAG, "Button btnCheckboxActivity clicked!");
                intent = new Intent(MainActivity.this, CheckboxActivity.class);
            }
            break;

            case IMAGE: {
                Log.d(LOG_TAG, "Button btnImageActivity clicked!");
                intent = new Intent(MainActivity.this, ImageviewActivity.class);
            }
            break;

            case LISTVIEW: {
                Log.d(LOG_TAG, "Button btnListviewActivity clicked!");
                intent = new Intent(MainActivity.this, ListviewActivity.class);
            }
            break;


            case LISTVIEW_DYNAMIC: {
                Log.d(LOG_TAG, "Button btnListViewDynamicActivity clicked!");
                intent = new Intent(MainActivity.this, ListViewDynamicActivity.class);
            }
            break;

            case LISTVIEW_ADVANCE: {
                Log.d(LOG_TAG, "Button btnListViewAdvancedActivity clicked!");
                intent = new Intent(MainActivity.this, ListviewAdvancedActivity.class);
            }
            break;

            case GRIDVIEW: {
                Log.d(LOG_TAG, "Button btnGridView clicked!");
                intent = new Intent(MainActivity.this, GridViewActivity.class);
            }
            break;

            case DATETIME_PICKER: {
                Log.d(LOG_TAG, "Button btndatetimepicker clicked!");
                intent = new Intent(MainActivity.this, DateTimeActivity.class);
            }
            break;

            case KARAOKE: {
                Log.d(LOG_TAG, "Button btnKaraoke clicked!");
                intent = new Intent(MainActivity.this, KaraokeActivity.class);
            }
            break;

            case LEARNING_ACTIVITY: {
                Log.d(LOG_TAG, "Button btnLearning activity clicked!");
                intent = new Intent(MainActivity.this, LearningActivity.class);
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
/*
    View.OnClickListener myOnlyhandler = new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = null;
            switch (((Button) v).getText()) {
                case Features.TEXT_EDIT.toString(): {
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

                case R.id.btnListViewAdvancedActivity: {
                    Log.d(LOG_TAG, "Button btnListViewAdvancedActivity clicked!");
                    intent = new Intent(MainActivity.this, ListviewAdvancedActivity.class);
                }
                break;

                case R.id.btnGridView: {
                    Log.d(LOG_TAG, "Button btnGridView clicked!");
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                }
                break;

                case R.id.btnDateTimePicker: {
                    Log.d(LOG_TAG, "Button btndatetimepicker clicked!");
                    intent = new Intent(MainActivity.this, DateTimeActivity.class);
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
    };*/
}
