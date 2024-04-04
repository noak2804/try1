package com.example.theproject.UserProfile;

import android.graphics.Bitmap;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserProfilePresenter implements Repository.LoadRecipesListener,Repository.LoadUserListener, Repository.LoadRecipePicListener{
    UserProfileActivity view;
    User user;

    public UserProfilePresenter(UserProfileActivity view) {
        this.view = view;
        ArrayList<RecipeInformation> recipes=new ArrayList<>();
        Repository.getInstance().setLoadRecipesListener(this);
        Repository.getInstance().setLoadRecipePicListener(this);
        Repository.getInstance().setLoadUserListener(this);
        Repository.getInstance().readUser( FirebaseAuth.getInstance().getUid());

        view.setRecyclerMine(recipes);
        view.setRecyclerSaved(recipes);
    }
    @Override
    public void updateRecipes(ArrayList<RecipeInformation> recipes) {
        ArrayList<String> recipesSavedId=user.getSavedRecipes();
        ArrayList<RecipeInformation> recipesMine=new ArrayList<>();
        ArrayList<RecipeInformation> recipesSave=new ArrayList<>();


        for (int i = 0; i < recipes.size(); i++)
        {
            RecipeInformation recipe =  recipes.get(i);

            if(recipe.getUserIdOwner().equals(FirebaseAuth.getInstance().getUid()))
            {
                recipesMine.add(recipe);
            }
            for (int k=0;k<recipesSavedId.size();k++)
            {
                if(recipe.getRecipeId().equals(recipesSavedId.get(k)))
                {
                    recipesSave.add(recipe);
                }
            }


        }
        for (int i = 0; i < recipes.size(); i++) {
            Repository.getInstance().loadRecipePic(recipes.get(i).getRecipeId());
        }

        view.setRecyclerSaved(recipesSave);
        view.setRecyclerMine(recipesMine);
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
    public void updateUser(User user) {
        this.user=user;
        Repository.getInstance().readRecipes();
    }
    @Override
    public void updateRecipePic(Bitmap bitmap, String id) {
        view.addBitmap(bitmap,id);
    }
}
