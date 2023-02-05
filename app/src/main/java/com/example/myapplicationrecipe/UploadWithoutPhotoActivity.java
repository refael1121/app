package com.example.myapplicationrecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadWithoutPhotoActivity extends AppCompatActivity {

    private EditText recipeNameEditText, ingredientsEditText, instructionsEditText;
    private Button saveButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_without_photo);

        recipeNameEditText = findViewById(R.id.recipeNameEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        instructionsEditText = findViewById(R.id.instructionsEditText);
        saveButton = findViewById(R.id.saveButton);

        databaseHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = recipeNameEditText.getText().toString();
                String ingredients = ingredientsEditText.getText().toString();
                String instructions = instructionsEditText.getText().toString();

                Recipe recipe = new Recipe(recipeName, ingredients, instructions,false);

                databaseHelper.addRecipeWithDetails(recipeName, ingredients, instructions,false);

                Toast.makeText(UploadWithoutPhotoActivity.this, "Recipe added successfully!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
