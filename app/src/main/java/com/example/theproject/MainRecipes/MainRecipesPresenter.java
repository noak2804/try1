package com.example.theproject.MainRecipes;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainRecipesPresenter implements Repository.LoadRecipesListener, Repository.LoadRecipePicListener, Repository.LoadUserListener {
    MainRecipesActivity view;
    User user;
    int max=0;
public MainRecipesPresenter(MainRecipesActivity view)
{
    this.view=view;
    ArrayList<RecipeInformation> recipes=new ArrayList<>();

    Repository.getInstance().setLoadRecipesListener(this);
    Repository.getInstance().readRecipes();
    Repository.getInstance().setLoadRecipePicListener(this);
    Repository.getInstance().setLoadUserListener(this);
    Repository.getInstance().readUser(FirebaseAuth.getInstance().getUid());
    view.setRecyclerBest(recipes);
    view.setRecyclerSweets(recipes);
    view.setRecyclerBreakfastLunch(recipes);





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
        for (int i = 0; i < recipes.size(); i++) {
            Repository.getInstance().loadRecipePic(recipes.get(i).getRecipeId());
        }
        view.setRecyclerBest(recipesBest);


    }
}

    @Override
    public void updateRecipePic(Bitmap bitmap, String id) {
        view.addBitmap(bitmap,id);
    }

    @Override
    public void updateUser(User user) {
        this.user=user;
        Toast.makeText(view, "welcome "+user.getName(), Toast.LENGTH_LONG).show();
    }
}
