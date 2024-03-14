package com.example.theproject.GroceryList;

import android.widget.TextView;

import com.example.theproject.R;
import com.example.theproject.Repository;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class GroceryListPresenter implements Repository.LoadUserListener{
    GroceryListActivity view;
    User user;
    String s="";
    public GroceryListPresenter(GroceryListActivity view) {
        this.view = view;

        Repository.getInstance().setLoadUserListener(this);
        Repository.getInstance().readUser( FirebaseAuth.getInstance().getUid());


        for(int i=0;i<user.getIngredientArray().size();i++)
        {
            for (int k=0; k<user.getIngredientArray().get(i).size();k++) {
                s +=  user.getIngredientArray().get(i).get(k).getIngredients() + " " + user.getIngredientArray().get(i).get(k).getAmount() + " " + user.getIngredientArray().get(i).get(k).getUnit() + "\n";
            }
        }
        view.setGroceryList(s);
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

    }
}
