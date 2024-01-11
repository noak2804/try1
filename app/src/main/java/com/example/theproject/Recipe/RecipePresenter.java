package com.example.theproject.Recipe;

public class RecipePresenter {
    RecipeActivity view;

    public RecipePresenter(RecipeActivity view) {
        this.view = view;
    }
    public void addGroceryListClicked()
    {
        view.navigatetoGroceryList();
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
