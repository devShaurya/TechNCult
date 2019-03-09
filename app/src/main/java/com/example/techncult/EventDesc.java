package com.example.techncult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class EventDesc extends AppCompatActivity {
    String venue,date,time,title,day,photo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_desc);
        intent=getIntent();
        venue=intent.getStringExtra("venue");
        date=intent.getStringExtra("date");
        time=intent.getStringExtra("time");
        title=intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);
        photo=intent.getStringExtra("photo");
        day= intent.getStringExtra("day");
        Log.d("msg",day+" "+date+ " "+venue+" "+time+" "+title+" "+photo);
    }
}
