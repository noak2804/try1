package com.example.theproject.GroceryList;

import android.widget.TextView;

import com.example.theproject.R;
import com.example.theproject.Repository;
import com.example.theproject.model.Ingredients;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class GroceryListPresenter implements Repository.LoadUserListener{
    GroceryListActivity view;
    User user;
    String s="";
    public GroceryListPresenter(GroceryListActivity view) {
        this.view = view;

        Repository.getInstance().setLoadUserListener(this);
        Repository.getInstance().readUser( FirebaseAuth.getInstance().getUid());



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
        ArrayList<Ingredients> ingredients;
        for(int i=0;i<user.getRecipesArray().size();i++)
        {
            s+=user.getRecipesArray().get(i).getName()+": "+"\n";
            ingredients = user.getRecipesArray().get(i).getIngredientArray();
            for (int k=0; k<ingredients.size();k++) {

                s +=  ingredients.get(k).getIngredients() + " " + ingredients.get(k).getAmount() + " " + ingredients.get(k).getUnit() + "\n";
            }
        }
        view.setGroceryList(s);
    }
}
