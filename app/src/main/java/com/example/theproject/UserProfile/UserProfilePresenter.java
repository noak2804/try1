package com.example.theproject.UserProfile;

import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class UserProfilePresenter {
    UserProfileActivity view;

    public UserProfilePresenter(UserProfileActivity view) {
        this.view = view;
        ArrayList<RecipeInformation> recipes=new ArrayList<>(30);
        for (int i=0; i<30;i++)
        {
            recipes.add(new RecipeInformation("n","x","z"));
        }
        view.setRecyclerMine(recipes);
        view.setRecyclerSaved(recipes);
    }
    public void groceryListClicked()
    {
        view.navigatetoGroceryList();
    }
}
