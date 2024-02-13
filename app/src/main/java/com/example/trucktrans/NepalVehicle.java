package com.example.trucktrans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NepalVehicle extends AppCompatActivity {

    RecyclerView recyclerViewv;
    ArrayList<User2> list;
    DatabaseReference databaseReference;
    MAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nepal_vehicle);

        recyclerViewv=findViewById(R.id.recycleviewnpv);
        databaseReference= FirebaseDatabase.getInstance().getReference("users2");
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerViewv.setLayoutManager(linearLayoutManager);

        adapter=new MAdapter(this,list);
        recyclerViewv.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User2 user2= dataSnapshot.getValue(User2.class);
                    if(user2.getvstate2().equals("NEPAL") || user2.getdesti2().equals("NEPAL")){
                        list.add(user2);
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
