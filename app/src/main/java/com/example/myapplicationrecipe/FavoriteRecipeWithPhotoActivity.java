package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipeWithPhotoActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipe_with_photo);

        listView = findViewById(R.id.recycler_view);
        db = new DatabaseHelper(this);
        final List<Recipe> recipes = db.getAllFavoriteRecipesWithPhoto();

        FavoriteRecipeWithPhotoAdapter adapter =new FavoriteRecipeWithPhotoAdapter(this , (ArrayList<Recipe>) recipes);
        listView.setAdapter(adapter);


        db = DatabaseHelper.getInstance(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FavoriteRecipeWithPhotoActivity.this, RecipeActivityWithPhotoFavorite.class);

                intent.putExtra("recipe", recipes.get(position).getName());
                System.out.println(recipes.get(position).getName());
                intent.putExtra("photo", recipes.get(position).getPhoto());


                startActivity(intent);
            }
        });
    }
}
