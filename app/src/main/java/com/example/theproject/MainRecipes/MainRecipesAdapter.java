package com.example.theproject.MainRecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.theproject.R;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class MainRecipesAdapter extends RecyclerView.Adapter<MainRecipesAdapter.ViewHolder> implements Filterable {


    ArrayList<RecipeInformation> recipes;
    ArrayList<RecipeInformation> filteredRecipes;

    public MainRecipesAdapter(ArrayList<RecipeInformation> recipes){
        this.recipes=recipes;
        this.filteredRecipes=recipes;
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
        holder.name.setText(filteredRecipes.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeClickListener.recipeClick(filteredRecipes.get(holder.getAdapterPosition()));
            }
        });

    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charSequenceString = constraint.toString();
                if (charSequenceString.isEmpty()) {
                    filteredRecipes = recipes;
                } else {
                    ArrayList<RecipeInformation> filteredList = new ArrayList<RecipeInformation>();
                    for (RecipeInformation recipe : recipes) {
                        if (recipe.getName().toLowerCase().contains(charSequenceString.toLowerCase())) {
                            filteredList.add(recipe);
                        }
                        filteredRecipes = filteredList;
                    }

                }
                FilterResults results = new FilterResults();
                results.values = filteredRecipes;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                filteredRecipes = (ArrayList<RecipeInformation> ) filterResults.values;
                notifyDataSetChanged();
            }

        };


    }

    @Override
    public int getItemCount() {
        return filteredRecipes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameRecipe1);
        }
    }
}
