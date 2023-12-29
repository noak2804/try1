package com.example.theproject.GroceryList;

public class GroceryListPresenter {
    GroceryListActivity view;

    public GroceryListPresenter(GroceryListActivity view) {
        this.view = view;
    }
    public void ToRecipe()
    {
        view.navigatetoRecipe();
    }
}
