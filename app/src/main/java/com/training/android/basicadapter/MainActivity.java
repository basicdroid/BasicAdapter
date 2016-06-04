package com.training.android.basicadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ArrayList<String> numbers = new ArrayList<>();

    private ArrayAdapter<String> mAdapter;
    private EditText mEtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        mEtData = (EditText) findViewById(R.id.etEnterData);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);

        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");

        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data = mEtData.getText().toString();
        mAdapter.add(data);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String data = numbers.get(position);
        Toast.makeText(this, "data = " + data, Toast.LENGTH_SHORT).show();
    }
}
