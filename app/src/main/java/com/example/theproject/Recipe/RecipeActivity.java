
package com.example.theproject.Recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.GroceryList.GroceryListActivity;

public class RecipeActivity extends AppCompatActivity {
RecipePresenter presenter;
    TextView nameTextView,ingredients,preparation,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        presenter=new RecipePresenter(this);
        nameTextView = findViewById(R.id.nameRecipe);
        nameTextView.setText("name");
        ingredients = findViewById(R.id.ingredients);
        ingredients.setText("something");
        preparation = findViewById(R.id.preparationRecipe);
        preparation.setText("first");
        type = findViewById(R.id.type);
        type.setText("lunch");

    }
    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void backToMainRecipe(View view) {
       presenter.BackClicked();
    }
    public void navigatetoGroceryList()
    {
        Intent intent=new Intent(this, GroceryListActivity.class);
        startActivity(intent);
    }
    public void groceryList(View view) {
        presenter.groceryListClicked();
    }
}