package com.example.mymemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button write_btn;
    ListView memo_list;
    static memoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        write_btn = (Button) findViewById(R.id.write_btn);
        write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), write_activity.class);
                startActivityForResult(intent,1001);
            }
        });

        memo_list = (ListView) findViewById(R.id.memo_list);
        adapter = new memoAdapter();
        memo_list.setAdapter(adapter);
        memo_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    class memoAdapter extends BaseAdapter{
        ArrayList<memoItem> items = new ArrayList<memoItem>();

        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem(memoItem item){
            items.add(item);

        }
        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            memoItemView memoView = null;
            if(view == null){
                memoView = new memoItemView(getApplicationContext());
            }else{
                memoView =(memoItemView)view;
            }

            memoItem item = items.get(i);
            memoView.setTitle(item.getTitle());
            memoView.setContent(item.getContent());

            return memoView;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //came from write activity
        if(resultCode == 100){
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");

            adapter.addItem(new memoItem(title, content));
            adapter.notifyDataSetChanged();

            Toast.makeText(this, title + content, Toast.LENGTH_LONG).show();

        }
    }
}