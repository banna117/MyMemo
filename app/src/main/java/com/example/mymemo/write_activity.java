package com.example.mymemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class write_activity extends AppCompatActivity {
    EditText text_title;
    EditText text_content;
    Button finish_btn;

    String title;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_activity);

        text_title=(EditText) findViewById(R.id.text_title);
        text_content = (EditText) findViewById(R.id.text_content);
        finish_btn = (Button) findViewById(R.id.finish_btn);

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                title = text_title.getText().toString();
                content = text_content.getText().toString();

                Intent intent = getIntent();
                processIntent(intent);

            }
        });


    }

    private void processIntent(Intent intent){
        intent.putExtra("title", title);
        intent.putExtra("content", content);

        setResult(100, intent);

        finish();
    }
}