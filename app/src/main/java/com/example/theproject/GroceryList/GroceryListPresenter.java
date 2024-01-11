package com.example.theproject.GroceryList;

public class GroceryListPresenter {
    GroceryListActivity view;

    public GroceryListPresenter(GroceryListActivity view) {
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
}
