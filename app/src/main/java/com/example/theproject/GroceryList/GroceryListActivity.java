package com.example.theproject.GroceryList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.NewRecipe.NewRecipeActivity;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.UserProfile.UserProfileActivity;

public class GroceryListActivity extends AppCompatActivity {
    GroceryListPresenter presenter;
    TextView namesRecipe,ingredList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
      presenter=new GroceryListPresenter(this);

     namesRecipe=findViewById(R.id.namesRecipe);
     ingredList=findViewById(R.id.ingredList);
     namesRecipe.setText("name");
     ingredList.setText("ingred");
    }
    public void navigatetoRecipe()
    {
        Intent intent=new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
    public void backToRecipe(View view) {
        presenter.ToRecipe();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.mainRecipe)
        {
            Intent intent=new Intent(this, MainRecipesActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.createNewRecipe)
        {
            Intent intent=new Intent(this, NewRecipeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.userProfile)
        {
            Intent intent=new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}