package com.example.theproject.model;

import android.media.Image;

import com.example.theproject.model.Ingredients;

import java.util.ArrayList;

public class RecipeInformation {
    String name;
    ArrayList<Ingredients> ingredientArray;
    String preparation;
    String category;

    public RecipeInformation(String name, String preparation, String category) {
        this.name = name;
        this.ingredientArray = new ArrayList<Ingredients>();
        this.preparation = preparation;
        this.category = category;
    }

    public ArrayList<Ingredients> getIngredientArray() {
        return ingredientArray;
    }

    public void setIngredientArray(ArrayList<Ingredients> ingredientArray) {
        this.ingredientArray = ingredientArray;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addIng(Ingredients temp)
    {
        ingredientArray.add(temp);
    }
}
