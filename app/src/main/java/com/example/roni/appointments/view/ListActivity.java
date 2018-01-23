package com.example.roni.appointments.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.roni.appointments.R;
import com.example.roni.appointments.controller.Controller;
import com.example.roni.appointments.controller.ListItemAdapter;
import com.example.roni.appointments.controller.OnListItemClick;
import com.example.roni.appointments.model.FakeDataSource;
import com.example.roni.appointments.model.ListItem;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface{
    private Controller controller;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rec_list_of_items);
        controller = new Controller(new FakeDataSource(), this);
    }

    @Override
    public void startDetailActivity(int photo, String dateAndTime, String description) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_PHOTO, photo);
        intent.putExtra(DetailActivity.EXTRA_DATE_AND_TIME, dateAndTime);
        intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, description);
        startActivity(intent);
    }

    @Override
    public void setUpViewAndAdapter(OnListItemClick onListItemClick, List<ListItem> listItems) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListItemAdapter listItemAdapter = new ListItemAdapter(onListItemClick, listItems);
        recyclerView.setAdapter(listItemAdapter);
    }
}
