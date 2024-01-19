package com.example.theproject.model;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.Recipe.RecipeActivity;

import java.util.ArrayList;

public class User {
    String name;
    String email;
    Integer phone;
    String password;
    ArrayList<RecipeActivity> myRecipes;
    ArrayList<RecipeActivity> savedRecipes;
    ArrayList<Ingredients> gregoryList;

    public User()
    {

    }

    public User(String name, String email, Integer phone, String password, ArrayList<RecipeActivity> myRecipes, ArrayList<RecipeActivity> savedRecipes, ArrayList<Ingredients> gregoryList) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.myRecipes = new ArrayList<RecipeActivity>();
        this.savedRecipes = new ArrayList<RecipeActivity>();
        this.gregoryList = new ArrayList<Ingredients>();
    }
}
