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
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.Repository;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class GroceryListActivity extends AppCompatActivity  {
    GroceryListPresenter presenter;
    TextView namesRecipe,ingredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
      presenter=new GroceryListPresenter(this);



        ingredList=findViewById(R.id.ingredList);



    }
    public void setGroceryList(String s)
    {
        ingredList.setText(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

    }
    public void navigatetoRecipe()
    {
        Intent intent=new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
    public void navigatetoCreateNewRecipe()
    {
        Intent intent=new Intent(this, NewRecipeActivity.class);
        startActivity(intent);
    }
    public void navigatetoUserProfile()
    {
        Intent intent=new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
    public void navigatetoGroceryList()
    {
        Intent intent=new Intent(this, GroceryListActivity.class);
        startActivity(intent);
    }
    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

   @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.mainRecipe)
        {
            presenter.ToMainRecipes();
        }
        else if(id==R.id.createNewRecipe)
        {
            presenter.ToCreateNewRecipeClicked();
        }
        else if(id==R.id.userProfile)
        {
            presenter.ToUserProfile();
        }
        else if(id==R.id.groceryList)
        {
            presenter.ToGroceryList();
        }
        else if(id==R.id.logOut)
        {
            presenter.ToLogOut();
        }
        return super.onOptionsItemSelected(item);
    }


}