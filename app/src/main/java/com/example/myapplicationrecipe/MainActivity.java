package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnUpload, btnSearch, btnFavorites, btnSearchIngred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpload = findViewById(R.id.btn_upload);
        btnSearch = findViewById(R.id.btn_search);
        btnSearchIngred = findViewById(R.id.btn_searchIngred);
        btnFavorites = findViewById(R.id.btn_favorites);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadIntent = new Intent(MainActivity.this, UploadRecipeActivity.class);
                startActivity(uploadIntent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, SearchRecipeActivity.class);
                startActivity(searchIntent);
            }
        });

        btnSearchIngred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchingred = new Intent(MainActivity.this, SearchByIngredients.class);
                startActivity(searchingred);
            }
        });
        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoriteIntent = new Intent(MainActivity.this, FavoriteRecipeActivity.class);
                startActivity(favoriteIntent);
            }
        });
    }
}
