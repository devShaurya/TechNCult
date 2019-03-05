package com.example.techncult;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Councilinfo extends Fragment {
    public Councilinfo() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.council_fragment,container,false);
        Bundle bundle=getArguments();
        TextView coun=view.findViewById(R.id.coun);
        int tech=bundle.getInt("tech");
        if(tech==0){
            coun.setText("tech evnts");
        }else{
            coun.setText("Cult events");
        }


        return  view;
    }
}
