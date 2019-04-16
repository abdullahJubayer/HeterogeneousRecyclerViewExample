package com.example.hetarogeneousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerAdapter recyclerAdapter;
    ArrayList<Object> object=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        object.add(new Model1("x","y"));
        object.add(new Model2("X","Y","A","B"));
        object.add(new Model1("Ami","Tumi"));
        object.add(new Model2("Xx","Yy","Aa","Bb"));
        object.add(new Model1("x","y"));
        object.add(new Model2("X","Y","A","B"));
        object.add(new Model1("Ami","Tumi"));
        object.add(new Model2("Xx","Yy","Aa","Bb"));

        recyclerView=findViewById(R.id.recycler_id);
        recyclerAdapter=new MyRecyclerAdapter(object);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
