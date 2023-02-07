package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class SearchWithPhotoActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_with_photo);

        listView = findViewById(R.id.list_view2);
        db = new DatabaseHelper(this);
        final List<Recipe> recipes = db.getAllRecipesWithPhoto();

        RecipeListAdapter adapter = new RecipeListAdapter(this, recipes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchWithPhotoActivity.this, RecipeActivityWithPhoto.class);

                intent.putExtra("recipe", recipes.get(position).getName());
                intent.putExtra("photo", recipes.get(position).getPhoto());


                startActivity(intent);
            }
        });
    }
}
