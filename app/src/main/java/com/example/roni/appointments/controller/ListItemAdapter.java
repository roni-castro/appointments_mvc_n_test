package com.example.roni.appointments.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roni.appointments.R;
import com.example.roni.appointments.model.ListItem;

import java.util.List;

/**
 * Created by roni on 23/01/18.
 */

public class ListItemAdapter extends RecyclerView.Adapter {
    private List<ListItem> listItems;
    private OnListItemClick controller;

    public ListItemAdapter(OnListItemClick controller, List<ListItem> listItemList){
        this.controller = controller;
        this.listItems = listItemList;
    }

    @Override
    public int getItemCount(){
        return listItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_apointment, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ListItem listItem = listItems.get(position);
        ListItemViewHolder viewHolder = (ListItemViewHolder) holder;
        viewHolder.photo.setImageResource(listItem.getPhoto());
        viewHolder.description.setText(listItem.getDescription());
        viewHolder.dateAndTime.setText(listItem.getDateAndTime());
    }

    private class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView photo;
        private TextView dateAndTime;
        private TextView description;
        private ViewGroup container;

        public ListItemViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_photo);
            dateAndTime = itemView.findViewById(R.id.txt_date);
            description = itemView.findViewById(R.id.txt_description);
            container = itemView.findViewById(R.id.container);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            controller.onListItemClick(listItems.get(this.getAdapterPosition()));
        }
    }
}
