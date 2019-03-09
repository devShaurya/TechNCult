package com.example.techncult;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Technical extends Fragment {
    private FirebaseFirestore db;
    private EventAdapter eventAdapter;
    private List<Events> eventsList;
    private RecyclerView recyclerView;
    public Technical(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tech_fragment, container, false);
        FirebaseApp.initializeApp(getContext());
        db= FirebaseFirestore.getInstance();
        eventsList=new ArrayList<>();
        recyclerView=view.findViewById(R.id.tech_recycler);
        eventAdapter=new EventAdapter(eventsList,getContext());
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        db.collection("Tech events").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<DocumentSnapshot> documentSnapshots=task.getResult().getDocuments();
                for(int i=0;i<documentSnapshots.size();i++){
                    eventsList.add(documentSnapshots.get(i).toObject(Events.class));
                    eventAdapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
