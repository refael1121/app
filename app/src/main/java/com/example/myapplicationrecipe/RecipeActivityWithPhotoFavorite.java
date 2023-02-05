package com.example.myapplicationrecipe;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivityWithPhotoFavorite extends AppCompatActivity {

    private ImageView recipeImageView;
    private TextView recipeNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_recipe_photo_favorite);

        recipeImageView = findViewById(R.id.image_view_recipe_photo_favorite);
        recipeNameTextView = findViewById(R.id.text_view_recipe_name_favorite);

        Intent intent = getIntent();

        String name = intent.getStringExtra("recipe");
        byte[] photo = intent.getByteArrayExtra("photo");

        recipeNameTextView.setText(name);
        recipeImageView.setImageBitmap(BitmapFactory.decodeByteArray(photo, 0, photo.length));
    }
}
