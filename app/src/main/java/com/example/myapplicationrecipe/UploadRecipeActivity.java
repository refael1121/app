package com.example.myapplicationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UploadRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUploadWithPhoto;
    private Button btnUploadWithoutPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);

        btnUploadWithPhoto = findViewById(R.id.btn_upload_with_photo);
        btnUploadWithoutPhoto = findViewById(R.id.btn_upload_without_photo);

        btnUploadWithPhoto.setOnClickListener(this);
        btnUploadWithoutPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_upload_with_photo:
                startActivity(new Intent(this, UploadWithPhotoActivity.class));
                break;
            case R.id.btn_upload_without_photo:
                startActivity(new Intent(this, UploadWithoutPhotoActivity.class));
                break;
        }
    }
}
