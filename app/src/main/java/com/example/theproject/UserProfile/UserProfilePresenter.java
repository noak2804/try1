package com.example.theproject.UserProfile;

import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserProfilePresenter {
    UserProfileActivity view;

    public UserProfilePresenter(UserProfileActivity view) {
        this.view = view;
        ArrayList<RecipeInformation> recipes=new ArrayList<>(30);
        for (int i=0; i<30;i++)
        {
            recipes.add(new RecipeInformation(null,"b"+1, FirebaseAuth.getInstance().getUid(),null,"","category",null,0));
        }
        view.setRecyclerMine(recipes);
        view.setRecyclerSaved(recipes);
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
