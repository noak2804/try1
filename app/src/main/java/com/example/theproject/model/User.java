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
    ArrayList< RecipeInformation> recipesArray;
    ArrayList<String> savedRecipes;


   public User(){
       email="";
       name="";
       phone=null;
       password="";
       id="";
       this.savedRecipes = new ArrayList<String>();
       this.recipesArray=new ArrayList<>();

   }


    public User(String name, String email, Integer phone, String password,String id, ArrayList<String> savedRecipes, ArrayList<RecipeInformation> recipesArray) {
       super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.id=id;
        this.savedRecipes=savedRecipes;
        this.recipesArray=recipesArray;

    }


    public ArrayList<RecipeInformation> getRecipesArray() {
        return recipesArray;
    }


    public void setRecipesArray(ArrayList<RecipeInformation> recipesArray) {
        this.recipesArray = recipesArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
