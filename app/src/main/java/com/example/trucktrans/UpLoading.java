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

public class UpLoading extends AppCompatActivity {

    RecyclerView recyclerViewup;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    ImageView Lorry,Trailor,Tanker,Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_loading2);

        Lorry=findViewById(R.id.Uplorry);
        Trailor=findViewById(R.id.Uptrailor);
        Tanker =findViewById(R.id.Uptanker);
        Container=findViewById(R.id.Upcontainer);
        Lorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpLoading.this,UpLorry.class);
                startActivity(intent);
            }
        });
        Trailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpLoading.this,UpTrailor.class);
                startActivity(intent);
            }
        });
        Tanker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpLoading.this,UpTanker.class);
                startActivity(intent);
            }
        });
        Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpLoading.this,UpContainer.class);
                startActivity(intent);
            }
        });

        recyclerViewup=findViewById(R.id.recycleviewup);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewup.setLayoutManager(linearLayoutManager);

        adapter=new MyAdapter(this,list);
        recyclerViewup.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User user= dataSnapshot.getValue(User.class);
                    if(user.getlstate().equals("UP") || user.getustate().equals("UP")){
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
