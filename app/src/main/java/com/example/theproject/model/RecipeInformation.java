package com.example.theproject.model;

import android.graphics.Bitmap;
import android.media.Image;

import com.example.theproject.model.Ingredients;

import java.util.ArrayList;

public class RecipeInformation {
    String name;
Boolean ifIngredientsSave;
    Integer averageRating;
    String userIdOwner;
    String recipeId;
    ArrayList<Ingredients> ingredientArray;
    String preparation;
    String category;
    ArrayList<String> usersId;
    Integer cookTime;
    ArrayList<String> rating;
    ArrayList<Double> numOfRating;
    public RecipeInformation()
    {
        name="";
        this.preparation = "";
        this.category = "";

        usersId=new ArrayList<>();
        userIdOwner="";
        recipeId="";
        this.ingredientArray = new ArrayList<>();
        cookTime=null;
        averageRating=null;
        ifIngredientsSave=false;
        rating=new ArrayList<>();
        numOfRating=new ArrayList<>();
    }
    public RecipeInformation(String recipeId,String name,String ownerUserId,ArrayList<Ingredients> ingredientArray, String preparation, String category, Integer cookTime,Integer averageRating,Boolean ifIngredientsSave,ArrayList<String> rating,ArrayList<Double> numOfRating) {
        super();
        this.name = name;
        this.ingredientArray = ingredientArray;
        this.preparation = preparation;
        this.category = category;

        usersId=new ArrayList<>();
        this.userIdOwner=ownerUserId;
        this.recipeId=recipeId;
       this.cookTime=cookTime;
       this.averageRating=averageRating;
       this.ifIngredientsSave=ifIngredientsSave;
       this.rating=rating;
       this.numOfRating=numOfRating;
    }

    public ArrayList<Double> getNumOfRating() {
        return numOfRating;
    }

    public void setNumOfRating(ArrayList<Double> numOfRating) {
        this.numOfRating = numOfRating;
    }

    public ArrayList<String> getRating() {
        return rating;
    }

    public void setRating(ArrayList<String> rating) {
        this.rating = rating;
    }


    public Boolean getIfIngredientsSave() {
        return ifIngredientsSave;
    }

    public void setIfIngredientsSave(Boolean ifIngredientsSave) {
        this.ifIngredientsSave = ifIngredientsSave;
    }

    public Integer getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }


    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
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



}
