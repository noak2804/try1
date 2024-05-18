package com.example.theproject.model;

public class Ingredients {
    String ingredients;
    int amount;
    String unit;

    public Ingredients(String ingredients, int amount, String unit) {
        this.ingredients = ingredients;
        this.amount = amount;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public int getAmount() {
        return amount;
    }

    public String getIngredients() {
        return ingredients;
    }

}
