package com.example.theproject.Recipe;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.example.theproject.Repository;
import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.Repo;

import java.util.ArrayList;

public class RecipePresenter implements Repository.LoadRecipesListener,Repository.LoadUserListener, Repository.LoadRecipePicListener  {
    RecipeActivity view;
    RecipeInformation recipe;
    String idRecipe;
    User user;
    Boolean ifIngredientsSave=false;
    Boolean ifRecipeSaved=false;

    public RecipePresenter(RecipeActivity view) {
        this.view = view;
        Repository.getInstance().setLoadRecipesListener(this);
        Repository.getInstance().setLoadRecipePicListener(this);
        Repository.getInstance().setLoadUserListener(this);
        Repository.getInstance().readUser(FirebaseAuth.getInstance().getUid());
    }
    public void addGroceryListClicked()
    {


        user.getIngredientArray().add(recipe);
        Repository.getInstance().addUser(user);
        ifIngredientsSave=true;
        recipe.setIfIngredientsSave(ifIngredientsSave);
        Repository.getInstance().createRecipe(recipe);

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
        idRecipe=b.getString("recipeId");
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
        Repository.getInstance().loadRecipePic(recipe.getRecipeId());

        view.setUi(recipe,user);

    }
    public void ratingArray(Double r)
    {
        if(recipe.getRating()==null)
        {
            recipe.setRating(new ArrayList<>());
        }
        if(recipe.getNumOfRating()==null)
        {
            recipe.setNumOfRating(new ArrayList<>());
        }
        if(recipe.getRating().contains(user.getId()))
        {
          for (int i = 0; i < recipe.getRating().size(); i++) {
            if(recipe.getRating().get(i).equals(user.getId()))
            {
                recipe.getNumOfRating().set(i,r);
            }
          }
        }
        else{
            recipe.getRating().add(user.getId());
            recipe.getNumOfRating().add(r);
        }

        Repository.getInstance().createRecipe(recipe);

    }
    public void average()
    {
        int sum=0;
        for (int i = 0; i < recipe.getNumOfRating().size(); i++) {
            sum+=recipe.getNumOfRating().get(i);
        }
        sum=sum/recipe.getNumOfRating().size();
        recipe.setAverageRating(sum);
        Repository.getInstance().createRecipe(recipe);
    }

    {

    }
    public void SaveRecipe()
    {
        if(user.getSavedRecipes()==null)
        {
            user.setSavedRecipes(new ArrayList<>());
        }
        int c=0;
        for (int i=0;i<user.getSavedRecipes().size();i++)
        {
            if(user.getSavedRecipes().get(i).equals(idRecipe))
            {
                c=1;
            }

        }
        if(c==0) {
            user.getSavedRecipes().add(idRecipe);
            Repository.getInstance().addUser(user);
        }
        else{
            user.getSavedRecipes().remove(idRecipe);
            Repository.getInstance().addUser(user);
        }

    }

    @Override
    public void updateUser(User user) {

        this.user = user;
        Repository.getInstance().readRecipes();
    }
    @Override
    public void updateRecipePic(Bitmap bitmap, String id) {
        view.addBitmap(bitmap);
    }
}
