package com.example.techncult;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PastEvents extends Fragment {
    public PastEvents() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pastevents_fragment,container,false);
        Bundle bundle=getArguments();
        int tech=bundle.getInt("tech");
        TextView past=view.findViewById(R.id.past);
        if(tech==0){
            past.setText("tech evnts");
        }else{
            past.setText("Cult events");
        }

        return view;
    }
}
