package com.example.theproject.model;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.Recipe.RecipeActivity;

import java.util.ArrayList;

public class User {
    String name;
    String email;
    Integer phone;
    String password;
    String id;
    ArrayList< RecipeInformation> ingredientArray;
    ArrayList<String> savedRecipes;


   public User(){
       email="";
       name="";
       phone=null;
       password="";
       id="";
       this.savedRecipes = new ArrayList<String>();
       this.ingredientArray=new ArrayList<>();

   }


    public User(String name, String email, Integer phone, String password,String id, ArrayList<String> savedRecipes, ArrayList<RecipeInformation> ingredientArray) {
       super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.id=id;
        this.savedRecipes=savedRecipes;
        this.ingredientArray=ingredientArray;

    }


    public ArrayList<RecipeInformation> getIngredientArray() {
        return ingredientArray;
    }

    public void setIngredientArray(ArrayList<RecipeInformation> ingredientArray) {
        this.ingredientArray = ingredientArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(ArrayList<String> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

}
