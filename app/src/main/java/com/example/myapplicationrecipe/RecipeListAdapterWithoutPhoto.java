package com.example.myapplicationrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RecipeListAdapterWithoutPhoto extends ArrayAdapter<Recipe> {
    private Context context;
    private List<Recipe> recipes;

    public RecipeListAdapterWithoutPhoto(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item_recipe_without_photo, parent, false);

        Recipe currentRecipe = recipes.get(position);

        TextView recipeNameTextView = listItem.findViewById(R.id.text_view_recipe_name);
        recipeNameTextView.setText(currentRecipe.getName());

        return listItem;
    }
}