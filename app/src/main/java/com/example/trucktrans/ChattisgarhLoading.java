package com.example.trucktrans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChattisgarhLoading extends AppCompatActivity {

    RecyclerView recyclerViewcg;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    ImageView Lorry,Trailor,Tanker,Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chattisgarh_loading);

        Lorry=findViewById(R.id.Cglorry);
        Trailor=findViewById(R.id.Cgtrailor);
        Tanker =findViewById(R.id.Cgtanker);
        Container=findViewById(R.id.Cgcontainer);
        Lorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChattisgarhLoading.this,ChattisgarhLorry.class);
                startActivity(intent);
            }
        });
        Trailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChattisgarhLoading.this,ChattisgarhTrailor.class);
                startActivity(intent);
            }
        });
        Tanker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChattisgarhLoading.this,ChattisgarhTanker.class);
                startActivity(intent);
            }
        });
        Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChattisgarhLoading.this,ChattisgarhContainer.class);
                startActivity(intent);
            }
        });

        recyclerViewcg=findViewById(R.id.recycleviewcg);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewcg.setLayoutManager(linearLayoutManager);

        adapter=new MyAdapter(this,list);
        recyclerViewcg.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User user= dataSnapshot.getValue(User.class);
                    if(user.getlstate().equals("CHATTISGARH") || user.getustate().equals("CHATTISGARH")){
                        list.add(user);
                    }
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}