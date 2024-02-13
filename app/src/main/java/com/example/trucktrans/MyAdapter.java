package com.example.trucktrans;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<User> list;
    private StorageReference storageReference;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        String profilePicUrl = user.getProfilePicUrl();

        holder.mob.setText(user.getmob());
        holder.name.setText(user.getname());
        holder.req.setText(user.getreq());
        holder.larea.setText(user.getlarea());
        holder.lcity.setText(user.getlcity());
        holder.lstate.setText(user.getlstate());
        holder.uarea.setText(user.getuarea());
        holder.ucity.setText(user.getucity());
        holder.ustate.setText(user.getustate());
        holder.disc.setText(user.getdisc());
        holder.rate.setText(user.getrate());
        holder.td.setText(user.gettd());

        holder.bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = user.getmob();
                String call = "tel:" + mobileNumber.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(call));
                holder.mob.getContext().startActivity(intent);
            }
        });

        if (profilePicUrl != null) {
            // Show ProgressBar while loading
            holder.progressBar.setVisibility(View.VISIBLE);

            // Load the image asynchronously
            Picasso.get().load(profilePicUrl).into(holder.profilePictureImageView, new Callback() {
                @Override
                public void onSuccess() {
                    // Hide ProgressBar when image loading is successful
                    holder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError(Exception e) {
                    // Handle any errors
                    holder.progressBar.setVisibility(View.GONE);
                    // Load a default image or show an error message
                    holder.profilePictureImageView.setImageResource(android.R.drawable.ic_delete);
                }
            });
        } else {
            holder.progressBar.setVisibility(View.GONE);
            holder.profilePictureImageView.setImageResource(R.drawable.addtext_07_15_10_09_19);
        }

        holder.profilePictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                // You can open a new activity to display the larger image
                Intent intent = new Intent(context, LargeImageActivity.class);
                intent.putExtra("image_url", profilePicUrl); // Pass the image URL to the new activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mob, name, req, larea, lcity, lstate, uarea, ucity, ustate, disc, rate, td;
        ImageView bcall;
        ImageView profilePictureImageView;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mob = itemView.findViewById(R.id.textmob);
            name = itemView.findViewById(R.id.textname);
            req = itemView.findViewById(R.id.textreq);
            larea = itemView.findViewById(R.id.textlarea);
            lcity = itemView.findViewById(R.id.textlcity);
            lstate = itemView.findViewById(R.id.textlstate);
            uarea = itemView.findViewById(R.id.textuarea);
            ucity = itemView.findViewById(R.id.textucity);
            ustate = itemView.findViewById(R.id.textustate);
            disc = itemView.findViewById(R.id.textdisc);
            rate = itemView.findViewById(R.id.textrate);
            td = itemView.findViewById(R.id.texttd);
            bcall = itemView.findViewById(R.id.btncall);
            profilePictureImageView = itemView.findViewById(R.id.profilePictureImageView);
            progressBar = itemView.findViewById(R.id.itemProgressBar); // Replace with your ProgressBar ID
        }
    }
}



