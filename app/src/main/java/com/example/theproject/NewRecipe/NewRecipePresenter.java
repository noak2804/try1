package com.example.theproject.NewRecipe;

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
}

