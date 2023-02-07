package com.example.myapplicationrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplicationrecipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipeWithoutPhotoAdapter extends ArrayAdapter<Recipe> {
    private List<Recipe> recipes;
    private Context context;

    public FavoriteRecipeWithoutPhotoAdapter(Context context, ArrayList<Recipe> favoriteRecipes) {
        super(context, 0, favoriteRecipes);
        this.context = context;
        this.recipes = favoriteRecipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_recipe_without_photo_favorite, parent, false);

        Recipe recipe = recipes.get(position);

        TextView nameTextView = rowView.findViewById(R.id.text_view_recipe_name_fav);

        nameTextView.setText(recipe.getName());

        return rowView;
    }

}
