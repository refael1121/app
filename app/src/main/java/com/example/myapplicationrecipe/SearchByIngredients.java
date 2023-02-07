package com.example.myapplicationrecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchByIngredients extends AppCompatActivity {
    private EditText ingredientsEditText;
    private Button searchButton;
    private ListView recipesListView;

    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_ingredients);

        db = new DatabaseHelper(this);
        recipeList = new ArrayList<>();

        ingredientsEditText = findViewById(R.id.editTextingredients);
        searchButton = findViewById(R.id.buttoningredients);
        recipesListView = findViewById(R.id.list_view_ingredients);

        recipeAdapter = new RecipeAdapter(this, recipeList);
        recipesListView.setAdapter(recipeAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredients = ingredientsEditText.getText().toString().trim();
                if (ingredients.isEmpty()) {
                    Toast.makeText(SearchByIngredients.this, "Please enter ingredients", Toast.LENGTH_SHORT).show();
                    return;
                }
                updateRecipeList(searchRecipes(ingredients));
            }
        });
    }

    private void updateRecipeList(List<Recipe> newList) {
        recipeList.clear();
        recipeList.addAll(newList);
        recipeAdapter.notifyDataSetChanged();
    }

    private List<Recipe> searchRecipes(String ingredients) {
        List<Recipe> matchingRecipes = new ArrayList<>();
        String[] ingredientList = ingredients.split(",");
        String combinedIngredients = "";

        for (String ingredient : ingredientList) {
            combinedIngredients += ingredient.trim() + " ";
        }

        for (Recipe recipe : db.getAllRecipes()) {
            if (combinedIngredients.contains(recipe.getIngredients())) {
                matchingRecipes.add(recipe);
            }
        }
        return matchingRecipes;
    }
}
