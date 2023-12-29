package com.example.theproject.MainRecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.theproject.R;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class MainRecipesAdapter extends RecyclerView.Adapter<MainRecipesAdapter.ViewHolder> {
    ArrayList<RecipeInformation> recipes;
    public MainRecipesAdapter(ArrayList<RecipeInformation> recipes){
        this.recipes=recipes;
    }
    public interface RecipeClickListener{
        void recipeClick(RecipeInformation recipe);
    }
    RecipeClickListener recipeClickListener;

    public void setRecipeClickListener(RecipeClickListener recipeClickListener) {
        this.recipeClickListener = recipeClickListener;
    }
    @NonNull
    @Override
    public MainRecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.main_recycle_recipes,parent,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecipesAdapter.ViewHolder holder, int position) {
        holder.name.setText(recipes.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeClickListener.recipeClick(recipes.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameRecipe1);
        }
    }
}
