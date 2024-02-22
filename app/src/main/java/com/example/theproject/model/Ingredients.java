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

    public Ingredients(){
        super();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
