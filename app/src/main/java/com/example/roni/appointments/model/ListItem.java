package com.example.roni.appointments.model;

/**
 * Created by roni on 23/01/18.
 */

public class ListItem {
    private int photo;
    private String dateAndTime;
    private String description;

    public ListItem(int photo, String dateAndTime, String description){
        this.photo = photo;
        this.dateAndTime = dateAndTime;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
