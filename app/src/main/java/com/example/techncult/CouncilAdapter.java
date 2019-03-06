package com.example.techncult;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CouncilAdapter extends RecyclerView.Adapter<CouncilAdapter.ViewHolder>{
    List<Council> councilList;
    Context context;
    public CouncilAdapter(List<Council> councilList, Context context) {
        this.councilList=councilList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singleclubs,viewGroup,false);
        return new CouncilAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Council council=councilList.get(i);
        viewHolder.nameView.setText(council.getTitle());
        Glide.with(context).load(council.getImg()).into(viewHolder.imgView);
    }

    @Override
    public int getItemCount() {
        return councilList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView imgView;
        public TextView nameView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            imgView=view.findViewById(R.id.club_thumbnail);
            nameView=view.findViewById(R.id.name);
        }
    }
}