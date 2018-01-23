package com.example.roni.appointments.controller;

import android.app.LauncherActivity;
import android.widget.AdapterView;

import com.example.roni.appointments.model.DataSourceInterface;
import com.example.roni.appointments.model.ListItem;
import com.example.roni.appointments.view.ViewInterface;

import java.util.List;

/**
 * Created by roni on 23/01/18.
 */



public class Controller implements OnListItemClick {

    private DataSourceInterface dataSourceInterface;
    private ViewInterface viewInterface;

    public Controller(DataSourceInterface dataSourceInterface, ViewInterface viewInterface) {
        this.dataSourceInterface = dataSourceInterface;
        this.viewInterface = viewInterface;

        getListOfItemsFromDataSource();
    }

    public void getListOfItemsFromDataSource() {
        List<ListItem> listItemList = dataSourceInterface.getListOfData();
        viewInterface.setUpViewAndAdapter(this, listItemList);
    }

    @Override
    public void onListItemClick(ListItem listItem) {
        viewInterface.startDetailActivity(
                listItem.getPhoto(),
                listItem.getDateAndTime(),
                listItem.getDescription()
        );
    }
}
