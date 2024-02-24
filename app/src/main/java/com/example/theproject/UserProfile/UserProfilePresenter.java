package com.example.theproject.UserProfile;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserProfilePresenter implements Repository.LoadRecipesListener{
    UserProfileActivity view;

    public UserProfilePresenter(UserProfileActivity view) {
        this.view = view;
        ArrayList<RecipeInformation> recipes=new ArrayList<>();
        Repository.getInstance().setLoadRecipesListener(this);
        Repository.getInstance().readRecipes();
        view.setRecyclerMine(recipes);
        view.setRecyclerSaved(recipes);
    }
    @Override
    public void updateRecipes(ArrayList<RecipeInformation> recipes) {
        ArrayList<RecipeInformation> recipesSaved=new ArrayList<>();
        ArrayList<RecipeInformation> recipesMine=new ArrayList<>();


        for (int i = 0; i < recipes.size(); i++)
        {
            RecipeInformation recipe =  recipes.get(i);

            if(recipe.getUserIdOwner().equals(FirebaseAuth.getInstance().getUid()))
            {
                recipesMine.add(recipe);
            }
            recipesSaved.add(recipe);
        }
        view.setRecyclerSaved(recipesSaved);
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


}
