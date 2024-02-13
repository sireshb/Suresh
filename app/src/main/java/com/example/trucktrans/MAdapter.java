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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MAdapter extends RecyclerView.Adapter<MAdapter.MViewHolder> {
    Context context;
    ArrayList<User2> list;
    StorageReference storageReference;
    public MAdapter(Context context, ArrayList<User2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry2, parent, false);
        return new MAdapter.MViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MAdapter.MViewHolder holder, int position) {
        User2 user2 = list.get(position);
        String profilePicUrl = user2.getProfilePicUrl();
        holder.mob2.setText(user2.getmob2());
        holder.name2.setText(user2.getname2());
        holder.type2.setText(user2.gettype2());
        holder.size2.setText(user2.getsize2());
        holder.varea2.setText(user2.getvarea2());
        holder.vcity2.setText(user2.getvcity2());
        holder.vstate2.setText(user2.getvstate2());
        holder.desti2.setText(user2.getdesti2());
        holder.body2.setText(user2.getbody2());
        holder.td2.setText(user2.gettd2());


        holder.bcall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = user2.getmob2();
                String call = "tel:" + mobileNumber.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(call));
                holder.mob2.getContext().startActivity(intent);
            }
        });

        FirebaseAuth authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        if (profilePicUrl != null) {
            holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.get().load(profilePicUrl).into(holder.profilePictureImageView2, new com.squareup.picasso.Callback() {
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
                holder.profilePictureImageView2.setImageResource(android.R.drawable.ic_delete);
            }
        });
        } else {
        holder.progressBar.setVisibility(View.GONE);
            Picasso.get().load(R.drawable.addtext_07_15_10_09_19).into(holder.profilePictureImageView2);

        }
        holder.profilePictureImageView2.setOnClickListener(new View.OnClickListener() {
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
    public static class MViewHolder extends RecyclerView.ViewHolder {
        TextView mob2, name2, type2, size2, varea2, vcity2, vstate2, desti2, body2, td2;
        Button bcall2;
        ImageView profilePictureImageView2;
        ProgressBar progressBar;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            mob2 = itemView.findViewById(R.id.textmob2);
            name2 = itemView.findViewById(R.id.textname2);
            type2 = itemView.findViewById(R.id.texttype2);
            size2 = itemView.findViewById(R.id.textsize2);
            varea2 = itemView.findViewById(R.id.textvarea2);
            vcity2 = itemView.findViewById(R.id.textvcity2);
            vstate2 = itemView.findViewById(R.id.textvstate2);
            desti2 = itemView.findViewById(R.id.textdesti2);
            body2 = itemView.findViewById(R.id.textbody2);
            td2 = itemView.findViewById(R.id.texttd2);
            bcall2 = itemView.findViewById(R.id.btncall2);
            profilePictureImageView2 = itemView.findViewById(R.id.profilePictureImageView2);
            progressBar = itemView.findViewById(R.id.itemProgressBar);

        }
    }
}

