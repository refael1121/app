package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipeWithoutPhotoActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_without_photo_favorite);

        listView = findViewById(R.id.list_view_Favotire);
        db = new DatabaseHelper(this);
        final List<Recipe> recipes = db.getAllFavoriteRecipesWithoutPhoto();

        FavoriteRecipeWithoutPhotoAdapter adapter = new FavoriteRecipeWithoutPhotoAdapter(this, (ArrayList<Recipe>) recipes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (recipes.get(position) != null) {
                    Intent intent = new Intent(FavoriteRecipeWithoutPhotoActivity.this, RecipeActivityWithoutPhotoFavorite.class);
                    intent.putExtra("recipeName", recipes.get(position).getName());
                    intent.putExtra("recipeIngredients", recipes.get(position).getIngredients());
                    intent.putExtra("recipeInstructions", recipes.get(position).getInstructions());
                    startActivity(intent);
                } else {
                    Toast.makeText(FavoriteRecipeWithoutPhotoActivity.this, "Recipe not found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
