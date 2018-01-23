package com.example.roni.appointments.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roni.appointments.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "EXTRA_PHOTO";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";

    @BindView(R.id.img_photo) ImageView photoImageView;
    @BindView(R.id.txt_date) TextView dateAndTimeTextView;
    @BindView(R.id.txt_description) TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int photoRes = intent.getIntExtra(EXTRA_PHOTO, 0);
        String dateAndTime = intent.getStringExtra(EXTRA_DATE_AND_TIME);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        setUpView(photoRes, dateAndTime, description );
        setUpToolbarText();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpView(int photoRes, String dateAndTime, String description){
        photoImageView.setImageResource(photoRes);
        dateAndTimeTextView.setText(dateAndTime);
        descriptionTextView.setText(description);
    }

    private void setUpToolbarText(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detail of event");
        }
    }
}
