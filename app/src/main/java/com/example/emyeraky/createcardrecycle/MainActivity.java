package com.example.emyeraky.createcardrecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        //RecyclerView needs a LayoutManager to manage the positioning of its items.
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Emy Mohamed", "23 years old", R.drawable.lili));
        persons.add(new Person("Jousef", "25 years old", R.drawable.joe));
        persons.add(new Person("Eman Mohamed", "35 years old", R.drawable.lili));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }

}
