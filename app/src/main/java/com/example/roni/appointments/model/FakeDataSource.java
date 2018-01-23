package com.example.roni.appointments.model;

import com.example.roni.appointments.R;

import java.util.ArrayList;

/**
 * Created by roni on 23/01/18.
 */

public class FakeDataSource implements DataSourceInterface{
    private ArrayList<ListItem> listItems;

    private final String[] descriptions = {
            "Go to the dentists to check if there's everything ok",
            "Work out for 1 hour",
            "Go shopping for missing products",
            "Go to the college event"
    };

    private final String[] dates = {
            "20/03/2018",
            "28/05/2018",
            "29/03/2018",
            "30/04/2018",
    };

    private final int[] images = {
            R.drawable.dentist,
            R.drawable.academy,
            R.drawable.shopping,
            R.drawable.college_event,
    };

    @Override
    public ArrayList<ListItem> getListOfData() {

        ArrayList<ListItem> listItems = new ArrayList<>();
        for(int i=0; i< descriptions.length; i++){
            ListItem listItem = new ListItem(images[i], dates[i], descriptions[i]);
            listItems.add(listItem);
        }
        return listItems;
    }
}
