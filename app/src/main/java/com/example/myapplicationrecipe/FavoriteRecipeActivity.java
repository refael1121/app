package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FavoriteRecipeActivity extends AppCompatActivity {

    Button btnWithPhoto, btnWithoutPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipe);

        btnWithPhoto = findViewById(R.id.btn_with_photo);
        btnWithoutPhoto = findViewById(R.id.btn_without_photo);

        btnWithPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent withPhotoIntent = new Intent(FavoriteRecipeActivity.this, FavoriteRecipeWithPhotoActivity.class);
                startActivity(withPhotoIntent);
            }
        });

        btnWithoutPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent withoutPhotoIntent = new Intent(FavoriteRecipeActivity.this, FavoriteRecipeWithoutPhotoActivity.class);
                startActivity(withoutPhotoIntent);
            }
        });
    }
}
