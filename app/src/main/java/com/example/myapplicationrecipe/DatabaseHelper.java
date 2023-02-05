package com.example.myapplicationrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "recipes_db";
    // Table Name
    private static final String TABLE_NAME = "recipes";
    // Table Columns
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String INGREDIENTS = "ingredients";
    private static final String INSTRUCTIONS = "instructions";
    private static final String PHOTO = "photo";
    private static final String FAVORITE = "favorite";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME + " TEXT," +
                INGREDIENTS + " TEXT," +
                INSTRUCTIONS + " TEXT," +
                PHOTO + " BLOB," +
                FAVORITE + " INTEGER DEFAULT 0" +")";
        db.execSQL(createTable);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
    public List<Recipe> getAllFavoriteRecipesWithPhoto() {
        List<Recipe> favoriteRecipesWithPhoto = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE " +FAVORITE + " = 1 AND " + PHOTO + " IS NOT NULL";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setName(cursor.getString(1));
                recipe.setPhoto(cursor.getBlob(4));
                favoriteRecipesWithPhoto.add(recipe);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return favoriteRecipesWithPhoto;
    }

    public List<Recipe> getAllFavoriteRecipesWithoutPhoto() {
        List<Recipe> favoriteRecipesWithoutPhoto = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE " +FAVORITE + " = 0 AND " + PHOTO + " IS NULL";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setName(cursor.getString(1));
                recipe.setIngredients(cursor.getString(2));
                recipe.setInstructions(cursor.getString(3));
                favoriteRecipesWithoutPhoto.add(recipe);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return favoriteRecipesWithoutPhoto;
    }


    // Adding new recipe with name and photo
    public boolean addRecipeWithPhoto(String name, byte[] photo,Boolean favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PHOTO, photo);
        values.put(FAVORITE,favorite);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();

        return result != -1;
    }

    // Adding new recipe with name, ingredients, and instructions
    public boolean addRecipeWithDetails(String name, String ingredients, String instructions , Boolean favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(INGREDIENTS, ingredients);
        values.put(INSTRUCTIONS, instructions);
        values.put(FAVORITE,favorite);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();

        return result != -1;
    }




// Get all recipes
public List<Recipe> getAllRecipes() {
    List<Recipe> recipeList = new ArrayList<>();
    String selectQuery = "SELECT * FROM " + TABLE_NAME;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    if (cursor.moveToFirst()) {
        do {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getInt(0));
            recipe.setName(cursor.getString(1));
            recipe.setIngredients(cursor.getString(2));
            recipe.setInstructions(cursor.getString(3));
            recipe.setPhoto(cursor.getBlob(4));
            recipeList.add(recipe);
        } while (cursor.moveToNext());
    }

    cursor.close();
    db.close();
    return recipeList;
}
    public List<Recipe> getAllRecipesWithPhoto() {
        List<Recipe> recipeList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setName(cursor.getString(1));
                recipe.setPhoto(cursor.getBlob(4));
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return recipeList;
    }

// Update recipe
public int updateRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, recipe.getName());
        values.put(INGREDIENTS, recipe.getIngredients());
        values.put(INSTRUCTIONS, recipe.getInstructions());
        values.put(PHOTO,recipe.getPhoto());

    int result = db.update(TABLE_NAME, values, ID + " = ?", new String[]{String.valueOf(recipe.getId())});
    db.close();
    return result;
}
}
