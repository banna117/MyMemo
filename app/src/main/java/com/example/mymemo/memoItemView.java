package com.example.mymemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class memoItemView extends LinearLayout {
    TextView text_title;
    TextView text_content;

    public memoItemView(Context context) {
        super(context);
        init(context);
    }

    public memoItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate( R.layout.memo_item, this, true);

        text_title = (TextView) findViewById(R.id.text_title);
        text_content = (TextView) findViewById(R.id.text_content);
    }
    public void setTitle(String title){
        text_title.setText(title);
    }
    public void setContent(String content){
        text_content.setText(content);
    }
}
