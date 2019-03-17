package com.example.techncult;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{
    List<Events> eventList;
    Context context;
    public EventAdapter(List<Events> eventList, Context context) {
        this.eventList=eventList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_event,viewGroup,false);
        return new EventAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Events event=eventList.get(i);
//        Log.d("msg",event.getInfo()+" "+event.getPhoto()+event.getVenue()+event.getTitle());
        viewHolder.titleView.setText(event.getTitle());
        if (!(event.getPhoto().equals("Null"))){
            Glide.with(context).load(event.getPhoto()).into(viewHolder.imgView);
        }
        viewHolder.venueView.setText(event.getVenue());
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm a, MMM dd, yyyy ");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        final SimpleDateFormat dateFormatforDay=new SimpleDateFormat("EEEE");
        final SimpleDateFormat dateFormatforTime=new SimpleDateFormat("hh:mm a");
        final SimpleDateFormat dateFormatforDate=new SimpleDateFormat("MMM dd, yyyy");
        dateFormatforTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//        Log.d("msg",dateFormatforDate.format(event.getTime().toDate()));
//        Log.d("msg",event.getTime().toDate().toString());
        viewHolder.timeView.setText(dateFormat.format(event.getTime().toDate()));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,EventDesc.class);
                intent.putExtra("info",event.getInfo());
                intent.putExtra("venue",event.getVenue());
                intent.putExtra("title",event.getTitle());
                intent.putExtra("photo",event.getPhoto());
                intent.putExtra("day",dateFormatforDay.format(event.getTime().toDate()));
                intent.putExtra("date",dateFormatforDate.format(event.getTime().toDate()));
                intent.putExtra("time",dateFormatforTime.format(event.getTime().toDate()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView imgView;
        public TextView titleView, venueView, timeView;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            imgView=view.findViewById(R.id.photo_view);
            titleView=view.findViewById(R.id.title_view);
            venueView=view.findViewById(R.id.venue_view);
            timeView=view.findViewById(R.id.time_view);
            cardView=view.findViewById(R.id.card_view_event);
        }
    }
}