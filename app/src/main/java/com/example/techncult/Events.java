package com.example.techncult;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Events extends Fragment {
    int tech;

    public Events(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.events_fragment,container,false);

        Bundle bundle=getArguments();
        tech=bundle.getInt("tech");
        TextView ev=view.findViewById(R.id.events);
        if(tech==0){
            ev.setText("tech evnts");
        }else{
            ev.setText("Cult events");
        }
        return view;
    }
}
