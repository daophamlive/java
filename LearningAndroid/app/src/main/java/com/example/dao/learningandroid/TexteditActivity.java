package com.example.dao.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TexteditActivity extends AppCompatActivity {

    EditText editText;
    TextView textviewContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textedit);
        editText = (EditText) findViewById(R.id.txtInput);
        textviewContent = (TextView) findViewById(R.id.textviewContent);

        Intent intent = getIntent();
        String textFromActivity = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        editText.setText(textFromActivity);
    }

    public void onBackToMainActivity(View view) {

        Intent intent = null;
        Log.d(MainActivity.LOG_TAG, "Button Call_TextActivity clicked!");
        intent = new Intent(TexteditActivity.this, MainActivity.class);
        if (intent != null)
            startActivity(intent);
        finish();
    }

    public void onUpdateText(View view) {

        textviewContent.setText(editText.getText());
    }
}
