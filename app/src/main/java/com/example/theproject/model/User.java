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

    ArrayList<RecipeActivity> savedRecipes;


   public User(){
       email="";
       name="";
       phone=null;
       password="";
       id="";
       this.savedRecipes = new ArrayList<RecipeActivity>();
   }


    public User(String name, String email, Integer phone, String password,String id) {
       super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.id=id;
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

    public ArrayList<RecipeActivity> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(ArrayList<RecipeActivity> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

}
