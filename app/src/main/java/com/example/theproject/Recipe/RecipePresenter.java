package com.example.theproject.Recipe;

import android.os.Bundle;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class RecipePresenter implements Repository.LoadRecipesListener {
    RecipeActivity view;
    RecipeInformation recipe;

    public RecipePresenter(RecipeActivity view) {
        this.view = view;
        Repository.getInstance().setLoadRecipesListener(this);
        Repository.getInstance().readRecipes();
    }
    public void addGroceryListClicked()
    {
        view.navigatetoGroceryList();
    }
    public void ToCreateNewRecipeClicked()
    {
        view.navigatetoCreateNewRecipe();
    }
    public void ToUserProfile(){view.navigatetoUserProfile();}
    public void ToGroceryList(){view.navigatetoGroceryList();}
    public void ToMainRecipes(){view.navigatetoMainRecipes();}
    public void ToLogOut(){view.logout();}

    @Override
    public void updateRecipes(ArrayList<RecipeInformation> recipes) {
        Bundle b=view.getIntent().getExtras();
        String idRecipe=b.getString("recipeId");
        if(recipes!=null)
        {
            for (int i=0; i<recipes.size();i++)
            {
                if(recipes.get(i).getRecipeId().equals(idRecipe))
                {
                    recipe=recipes.get(i);
                }
            }
        }
        view.setUi(recipe);
    }
}
