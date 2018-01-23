package com.example.roni.appointments;

import com.example.roni.appointments.controller.Controller;
import com.example.roni.appointments.model.DataSourceInterface;
import com.example.roni.appointments.model.ListItem;
import com.example.roni.appointments.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Created by roni on 23/01/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    private  Controller controller;

    @Mock
    DataSourceInterface dataSourceInterface;

    @Mock
    ViewInterface viewInterface;

    private ListItem listItem = new ListItem(
            R.drawable.academy,
            "10/10/2010",
            "Description"
    );

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(dataSourceInterface, viewInterface);

    }

    @Test
    public void getDataSourceSuccessfully(){
        ArrayList<ListItem> listItems = new ArrayList<>();
        listItems.add(listItem);

        Mockito.when(dataSourceInterface.getListOfData()).thenReturn(listItems);

        controller.getListOfItemsFromDataSource();

        Mockito.verify(viewInterface).setUpViewAndAdapter(this, listItems);
    }
}
