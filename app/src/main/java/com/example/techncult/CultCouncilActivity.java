package com.example.techncult;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CultCouncilActivity extends AppCompatActivity {
    TextView clubName,clubInfo,contact_name,contact_email,contact_position,contact_number;
    ImageView contact_photo;
    RecyclerView recyclerView;
    FirebaseFirestore db;
    Intent intent;
    String council;
    List<Council> councilList;
    CouncilAdapter councilAdapter;
    String councilName;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council);

        FirebaseApp.initializeApp(CultCouncilActivity.this);

        db=FirebaseFirestore.getInstance();
        clubInfo=findViewById(R.id.clubInfo);
        contact_name=findViewById(R.id.contact_name);
        contact_number=findViewById(R.id.contact_number);
        contact_email=findViewById(R.id.contact_email);
        contact_position=findViewById(R.id.contact_position);
        contact_photo=findViewById(R.id.contact_photo);
        toolbar=findViewById(R.id.toolbar_council);
        clubName=findViewById(R.id.council_name);
        recyclerView=findViewById(R.id.club_recycler);
        intent=getIntent();
        navigationView=findViewById(R.id.nav_view_council);
        drawerLayout=findViewById(R.id.drawer_layout_council);
        council= intent.getStringExtra("Council");
        councilList=new ArrayList<>();
        councilAdapter=new CouncilAdapter(councilList, CultCouncilActivity.this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(CultCouncilActivity.this, drawerLayout,
                toolbar,
                R.string.opnDrw, R.string.clsDrw);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if(council.equals("Tech Council")){
            councilName="Technical Council";
            clubName.setText(councilName);
        }else{
            councilName="Cultural Council";
            clubName.setText(councilName);
        }
        recyclerView.setAdapter(councilAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(CultCouncilActivity.this,2));

        db.collection(council).whereEqualTo("club","1").get().addOnCompleteListener(
                CultCouncilActivity.this,
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        List<DocumentSnapshot> documentSnapshots=task.getResult().getDocuments();
                        for(int i=0;i<documentSnapshots.size();i++){
                            councilList.add(documentSnapshots.get(i).toObject(Council.class));
                            Log.d("msg",councilList.get(i).toString());
                            councilAdapter.notifyDataSetChanged();
                        }

                    }
                });
        db.collection(council).whereEqualTo("club","0").get().addOnCompleteListener(
                CultCouncilActivity.this,
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<DocumentSnapshot> documentSnapshots=task.getResult().getDocuments();
                        clubInfo.setText((CharSequence) documentSnapshots.get(0).get("info"));
                        contact_email.setText((CharSequence) documentSnapshots.get(0).get("email"));
                        contact_position.setText((CharSequence) documentSnapshots.get(0).get("position"));
                        contact_name.setText((CharSequence) documentSnapshots.get(0).get("name"));
                        Glide.with(CultCouncilActivity.this).load(
                                Uri.parse(String.valueOf(documentSnapshots.get(0).get("photo"))))
                                .into(contact_photo);
                    }
                }
        );
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.home:
                        intent=new Intent(CultCouncilActivity.this,MainActivity.class);
                        intent.putExtra("Council","Tech Council");
                        startActivity(intent);
                        break;
                    case R.id.techcouncil:
                        intent = new Intent(CultCouncilActivity.this, TechCouncilActivity.class);
                        intent.putExtra("Council", "Tech Council");
                        startActivity(intent);
                        break;
                    case R.id.website:
                        intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iitgn.ac.in/"));
                        startActivity(intent);
                        break;
                    case R.id.notification:
                        intent=new Intent(CultCouncilActivity.this,Notification.class);
                        startActivity(intent);
                        break;
                    case R.id.dev:
                        intent=new Intent(CultCouncilActivity.this,Developers.class);
                        startActivity(intent);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
