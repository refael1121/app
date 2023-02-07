package com.example.myapplicationrecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadWithoutPhotoActivity extends AppCompatActivity {

    private EditText recipeNameEditText, ingredientsEditText, instructionsEditText;
    private Button saveButton;
    private Switch toggleButton;
    private boolean addToFavorites = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_without_photo);

        recipeNameEditText = findViewById(R.id.recipeNameEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        instructionsEditText = findViewById(R.id.instructionsEditText);
        saveButton = findViewById(R.id.saveButton);
        toggleButton = findViewById(R.id.switchwithout);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addToFavorites = isChecked;
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = recipeNameEditText.getText().toString();
                String ingredients = ingredientsEditText.getText().toString();
                String instructions = instructionsEditText.getText().toString();

                DatabaseHelper dbClass = new DatabaseHelper(UploadWithoutPhotoActivity.this);
                dbClass.addRecipeWithDetails(recipeName,ingredients,instructions,addToFavorites);
                Toast.makeText(UploadWithoutPhotoActivity.this, "Recipe saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
