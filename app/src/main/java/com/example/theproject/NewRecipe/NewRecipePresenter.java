package com.example.theproject.NewRecipe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.Repository;
import com.example.theproject.model.Ingredients;
import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class NewRecipePresenter {
    NewRecipeActivity view;

    public NewRecipePresenter(NewRecipeActivity view) {
        this.view = view;

    }
    public void ToCreateNewRecipeClicked()
    {
        view.navigatetoCreateNewRecipe();
    }

    public void ToUserProfile(){view.navigatetoUserProfile();}
    public void ToGroceryList(){view.navigatetoGroceryList();}
    public void ToMainRecipes(){view.navigatetoMainRecipes();}
    public void ToLogOut(){view.logout();}
    public void CreateNewRecipeClicked(String name, ArrayList<Ingredients> ingredientArray, String preparation, String category, Bitmap image, String cookTime)
    {
        if(!name.equals("")&&ingredientArray!=null&&!preparation.equals("")&&!category.equals("")&&!cookTime.equals("")){
            RecipeInformation recipe=new RecipeInformation( "",name,FirebaseAuth.getInstance().getUid(),ingredientArray,preparation,category,image,Integer.parseInt(cookTime),0,false);
            Repository.getInstance().createRecipe(recipe);
            view.navigatetoMainRecipes();
        }
        else{
            Toast.makeText(view,"one of the fields is empty",Toast.LENGTH_LONG).show();

        }

    }
}

