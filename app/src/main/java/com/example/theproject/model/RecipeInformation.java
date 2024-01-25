package com.example.theproject.model;

import android.media.Image;

import com.example.theproject.model.Ingredients;

import java.util.ArrayList;

public class RecipeInformation {
    String name;
    String userIdOwner;
    String recipeId;
    ArrayList<Ingredients> ingredientArray;
    String preparation;
    String category;
    Image image;
    ArrayList<String> usersId;

    public RecipeInformation()
    {
        name="";
        this.preparation = "";
        this.category = "";
        this.image = null;
        usersId=new ArrayList<>();
        userIdOwner="";
        recipeId="";
        this.ingredientArray = new ArrayList<>();
    }
    public RecipeInformation(String recipeId,String name,String ownerUserId,ArrayList<Ingredients> ingredientArray, String preparation, String category,Image image) {
        super();
        this.name = name;
        this.ingredientArray = ingredientArray;
        this.preparation = preparation;
        this.category = category;
        this.image = image;
        usersId=new ArrayList<>();
        this.userIdOwner=ownerUserId;
        this.recipeId=recipeId;
    }

    public String getUserIdOwner() {
        return userIdOwner;
    }

    public void setUserIdOwner(String userIdOwner) {
        this.userIdOwner = userIdOwner;
    }

    public ArrayList<String> getUsersId() {
        return usersId;
    }

    public void setUsersId(ArrayList<String> usersId) {
        this.usersId = usersId;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getRatingbar() {
        return ratingbar;
    }

    public void setRatingbar(String ratingbar) {
        this.ratingbar = ratingbar;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
