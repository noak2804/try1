package com.example.theproject.MainRecipes;

import android.view.View;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainRecipesPresenter implements Repository.LoadRecipesListener{
    MainRecipesActivity view;
    int max=0;
public MainRecipesPresenter(MainRecipesActivity view)
{
    this.view=view;
    ArrayList<RecipeInformation> recipes=new ArrayList<>();

    Repository.getInstance().setLoadRecipesListener(this);
    Repository.getInstance().readRecipes();
    view.setRecyclerBest(recipes);
    view.setRecyclerSweets(recipes);
    view.setRecyclerBreakfastLunch(recipes);


    /*for (int i=0; i<30;i++)
    {
        recipesBreakfastLaunch.add(new RecipeInformation(null,"l"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
    }
    view.setRecyclerBreakfastLunch(recipesBreakfastLaunch);

    ArrayList<RecipeInformation> recipesSweets=new ArrayList<>(30);
    for (int i=0; i<30;i++)
    {
        recipesSweets.add(new RecipeInformation(null,"s"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
    }
    view.setRecyclerSweets(recipesSweets);*/
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
        ArrayList<RecipeInformation> recipesSweets=new ArrayList<>();
        ArrayList<RecipeInformation> recipesBreakfastLaunch=new ArrayList<>();
        ArrayList<RecipeInformation> recipesBest=new ArrayList<>();
        ArrayList<RecipeInformation> recipes2=new ArrayList<>();

        if (recipes.size() == 0)
        {

        }
        else {

            for (int i=0; i<recipes.size();i++)
            {
                RecipeInformation recipe =  recipes.get(i);

                if(recipe.getCategory().equals("lunch")||recipe.getCategory().equals("breakfast"))
                {
                    recipesBreakfastLaunch.add(recipe);
                }

                else if (recipe.getCategory().equals("sweets")) {
                    recipesSweets.add(recipe);
                }
            }
            view.setRecyclerSweets(recipesSweets);
            view.setRecyclerBreakfastLunch(recipesBreakfastLaunch);

        for (int i = 0; i < recipes.size(); i++)
        {
            RecipeInformation recipe =  recipes.get(i);
            recipes2.add(recipe);
        }




        for (int k=0; k<recipes.size();k++) {
            RecipeInformation recipebest = recipes2.get(0);
            int c=0;
            max=0;
            for (int i = 0; i < recipes2.size(); i++) {
                 RecipeInformation currentRec = recipes2.get(i);
                if (currentRec.getAverageRating() >= max) {
                    max = currentRec.getAverageRating();
                    recipebest=currentRec;
                    c = i;
                }

            }
            recipesBest.add(recipebest);
            recipes2.remove(c);

        }
        view.setRecyclerBest(recipesBest);


    }
}
}
