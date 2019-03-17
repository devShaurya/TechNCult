package com.example.techncult;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class EventDesc extends AppCompatActivity {
    String venue,date,time,title,day,photo,info;
    Intent intent;
    ImageView photoView;
    TextView infoView,timeView,venueView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_desc);

        photoView=findViewById(R.id.events_photo);
        infoView=findViewById(R.id.events_info);
        timeView=findViewById(R.id.events_time);
        venueView=findViewById(R.id.events_venue);

        intent=getIntent();
        info=intent.getStringExtra("info");
        venue=intent.getStringExtra("venue");
        date=intent.getStringExtra("date");
        time=intent.getStringExtra("time");
        title=intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);
        photo=intent.getStringExtra("photo");
        day= intent.getStringExtra("day");
//        Log.d("msg",day+" "+date+ " "+venue+" "+time+" "+title+" "+photo);
        if(!(photo.equals("Null"))){
            Glide.with(getBaseContext()).load(Uri.parse(photo)).apply(
                    RequestOptions.circleCropTransform()).into(photoView);
        }
        venueView.setText(venue);
        timeView.setText(date+ " "+ day+" "+ time);
        infoView.setText(info);
    }
}
