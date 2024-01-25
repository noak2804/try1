package com.example.theproject.MainRecipes;

import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainRecipesPresenter {
    MainRecipesActivity view;
public MainRecipesPresenter(MainRecipesActivity view)
{
    this.view=view;
    ArrayList<RecipeInformation> recipes=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipes.add(new RecipeInformation(null,"b"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
    }
    view.setRecyclerBest(recipes);

    ArrayList<RecipeInformation> recipesBreakfastLaunch=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipesBreakfastLaunch.add(new RecipeInformation(null,"l"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
    }
    view.setRecyclerBreakfastLunch(recipesBreakfastLaunch);

    ArrayList<RecipeInformation> recipesSweets=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipesSweets.add(new RecipeInformation(null,"s"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
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
