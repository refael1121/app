package com.example.myapplicationrecipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationrecipe.Recipe;

import java.util.List;
public class RecipeListAdapter extends ArrayAdapter<Recipe> {
    private Context context;
    private List<Recipe> recipes;

    public RecipeListAdapter(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_recipe_with_photo, parent, false);

        Recipe recipe = recipes.get(position);

        TextView recipeTitleTextView = rowView.findViewById(R.id.text_view_recipe_name2);
        recipeTitleTextView.setText(recipe.getName());


        return rowView;
    }
}
