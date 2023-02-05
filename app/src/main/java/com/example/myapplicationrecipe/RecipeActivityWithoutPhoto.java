package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivityWithoutPhoto extends AppCompatActivity {
    private TextView recipeName;
    private TextView recipeIngredients;
    private TextView recipeInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_without_photo);

        recipeName = findViewById(R.id.recipe_name);
        recipeIngredients = findViewById(R.id.recipe_ingredients);
        recipeInstructions = findViewById(R.id.recipe_instructions);

        Intent intent = getIntent();
        String name = intent.getStringExtra("recipeName");
        String ingredients = intent.getStringExtra("recipeIngredients");
        String instructions = intent.getStringExtra("recipeInstructions");

        recipeName.setText(name);
        recipeIngredients.setText(ingredients);
        recipeInstructions.setText(instructions);
    }
}
