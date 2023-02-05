package com.example.myapplicationrecipe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UploadWithPhotoActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private EditText recipeNameEditText;
    private ImageView recipeImageView;
    private Button chooseImageButton;
    private Button saveButton;
    private Bitmap recipeImage;
    private Switch toggleButton;
    private boolean addToFavorites = false;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_with_photo);

        recipeNameEditText =(EditText) findViewById(R.id.editText_recipeName);
        recipeImageView = findViewById(R.id.recipe_image_view);
        chooseImageButton = findViewById(R.id.choose_image_button);
        saveButton = findViewById(R.id.save_button);
        toggleButton = findViewById(R.id.toggleButton_addToFavorites);

        chooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addToFavorites = isChecked;
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = recipeNameEditText.getText().toString();
                if (recipeName.isEmpty() || recipeImage == null) {
                    Toast.makeText(UploadWithPhotoActivity.this, "Please enter a recipe name and choose an image", Toast.LENGTH_SHORT).show();
                } else {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    recipeImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();

                    Recipe recipe = new Recipe(recipeName, byteArray, addToFavorites);
                    DatabaseHelper dbClass = new DatabaseHelper(UploadWithPhotoActivity.this);
                    dbClass.addRecipeWithPhoto(recipeName,byteArray,addToFavorites);
                    Toast.makeText(UploadWithPhotoActivity.this, "Recipe saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                recipeImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                recipeImageView.setImageBitmap(recipeImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
