package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchRecipeActivity extends AppCompatActivity {

    Button searchWithPhotoButton, searchWithoutPhotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);

        searchWithPhotoButton = findViewById(R.id.searchWithPhotoButton);
        searchWithoutPhotoButton = findViewById(R.id.searchWithoutPhotoButton);

        searchWithPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchRecipeActivity.this, SearchWithPhotoActivity.class);
                startActivity(intent);
            }
        });

        searchWithoutPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchRecipeActivity.this, SearchWithoutPhotoActivity.class);
                startActivity(intent);
            }
        });
    }
}
