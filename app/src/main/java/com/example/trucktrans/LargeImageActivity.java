package com.example.trucktrans;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
public class LargeImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);
        ImageView largeImageView = findViewById(R.id.largeImageView);
        // Retrieve the image URL passed from the RecyclerView adapter
        String imageUrl = getIntent().getStringExtra("image_url");
        // Log the image URL to verify
        Log.d("LargeImageActivity", "Image URL: " + imageUrl);
        // Load the larger image using Picasso (or your preferred image loading library)
        if (imageUrl != null) {
            Picasso.get()
                    .load(imageUrl)
                    .into(largeImageView);
        }
    }
}
