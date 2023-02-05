package com.example.myapplicationrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationrecipe.Recipe;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private Context context;
    private List<Recipe> recipes;

    public RecipeAdapter(@NonNull Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item_ingredients, parent, false);

        Recipe currentRecipe = recipes.get(position);

        TextView name = listItem.findViewById(R.id.textViewIngredientsname);
        name.setText(currentRecipe.getName());

        TextView ingredients = listItem.findViewById(R.id.textViewIngredientsingredients);
        ingredients.setText(currentRecipe.getIngredients());

        TextView description = listItem.findViewById(R.id.textViewIngredientsinstructions);
        description.setText(currentRecipe.getInstructions());

        return listItem;
    }
}
