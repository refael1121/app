package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivityWithoutPhotoFavorite extends AppCompatActivity {

    private TextView recipeName;
    private TextView recipeIngredients;
    private TextView recipeInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_recipe_without_photo_favorite2);

        recipeName = findViewById(R.id.recipe_namefav);
        recipeIngredients = findViewById(R.id.recipe_ingredientsfav);
        recipeInstructions = findViewById(R.id.recipe_instructionsfav);
        Intent intent = getIntent();

        String name = intent.getStringExtra("recipeName");
        String ingredients = intent.getStringExtra("recipeIngredients");
        String instructions = intent.getStringExtra("recipeInstructions");

        recipeName.setText(name);
        recipeIngredients.setText(ingredients);
        recipeInstructions.setText(instructions);
    }
}
