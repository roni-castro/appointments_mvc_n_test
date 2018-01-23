package com.example.roni.appointments.view;

import com.example.roni.appointments.controller.Controller;
import com.example.roni.appointments.controller.OnListItemClick;
import com.example.roni.appointments.model.ListItem;

import java.util.List;

/**
 * Created by roni on 23/01/18.
 */

public interface ViewInterface {
    void startDetailActivity(int photo, String dateAndTime, String description);
    void setUpViewAndAdapter(OnListItemClick controller, List<ListItem> listItems);
}
