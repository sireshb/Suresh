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

public class JharkhandLoading extends AppCompatActivity {

    RecyclerView recyclerViewjr;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    ImageView Lorry,Trailor,Tanker,Container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jharkhand_loading);

        Lorry=findViewById(R.id.Jrlorry);
        Trailor=findViewById(R.id.Jrtrailor);
        Tanker =findViewById(R.id.Jrtanker);
        Container=findViewById(R.id.Jrcontainer);
        Lorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JharkhandLoading.this,JharkhandLorry.class);
                startActivity(intent);
            }
        });
        Trailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JharkhandLoading.this,JharkhandTrailor.class);
                startActivity(intent);
            }
        });
        Tanker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JharkhandLoading.this,JharkhandTanker.class);
                startActivity(intent);
            }
        });
        Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JharkhandLoading.this,JharkhandContainer.class);
                startActivity(intent);
            }
        });

        recyclerViewjr=findViewById(R.id.recycleviewjr);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewjr.setLayoutManager(linearLayoutManager);

        adapter=new MyAdapter(this,list);
        recyclerViewjr.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User user= dataSnapshot.getValue(User.class);
                    if(user.getlstate().equals("JHARKHAND") || user.getustate().equals("JHARKHAND")){
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

