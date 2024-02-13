package com.example.trucktrans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TelanganaLoading extends AppCompatActivity {

    RecyclerView recyclerViewts;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    ImageView Lorry,Trailor,Tanker,Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telangana_loading);

        Lorry=findViewById(R.id.Tslorry);
        Trailor=findViewById(R.id.Tstrailor);
        Tanker =findViewById(R.id.Tstanker);
        Container=findViewById(R.id.Tscontainer);
        Lorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelanganaLoading.this,TelanganaLorry.class);
                startActivity(intent);
            }
        });
        Trailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelanganaLoading.this,TelanganaTrailor.class);
                startActivity(intent);
            }
        });
        Tanker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelanganaLoading.this,TelanganaTanker.class);
                startActivity(intent);
            }
        });
        Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelanganaLoading.this,TelanganaContainer.class);
                startActivity(intent);
            }
        });

        recyclerViewts=findViewById(R.id.recycleviewts);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewts.setLayoutManager(linearLayoutManager);

        adapter=new MyAdapter(this,list);
        recyclerViewts.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User user= dataSnapshot.getValue(User.class);
                    if(user.getlstate().equals("TELANGANA") || user.getustate().equals("TELANGANA")){
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
