package com.example.theproject.Recipe;

public class RecipePresenter {
    RecipeActivity view;

    public RecipePresenter(RecipeActivity view) {
        this.view = view;
    }
    public void BackClicked()
    {
        view.navigatetoMainRecipes();
    }
    public void groceryListClicked()
    {
        view.navigatetoGroceryList();
    }
}
