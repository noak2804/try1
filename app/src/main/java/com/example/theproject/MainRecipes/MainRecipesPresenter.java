package com.example.theproject.MainRecipes;

import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class MainRecipesPresenter {
    MainRecipesActivity view;
public MainRecipesPresenter(MainRecipesActivity view)
{
    this.view=view;
    ArrayList<RecipeInformation> recipes=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipes.add(new RecipeInformation("b+i",null,"z","best",true,"4"));
    }
    view.setRecyclerBest(recipes);

    ArrayList<RecipeInformation> recipesBreakfastLaunch=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipesBreakfastLaunch.add(new RecipeInformation("l"+i,null,"z","lunch",true,"4"));
    }
    view.setRecyclerBreakfastLunch(recipesBreakfastLaunch);

    ArrayList<RecipeInformation> recipesSweets=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipesSweets.add(new RecipeInformation("s"+i,null,"z","sweets",true,"4"));
    }
    view.setRecyclerSweets(recipesSweets);
}
    public void ToCreateNewRecipeClicked()
    {
        view.navigatetoCreateNewRecipe();
    }
    public void ToUserProfile(){view.navigatetoUserProfile();}
    public void ToGroceryList(){view.navigatetoGroceryList();}
    public void ToMainRecipes(){view.navigatetoMainRecipes();}
    public void ToLogOut(){view.logout();}
}
