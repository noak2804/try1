package com.example.theproject.MainRecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.theproject.NewRecipe.NewRecipeActivity;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class MainRecipesActivity extends AppCompatActivity implements MainRecipesAdapter.RecipeClickListener {

    MainRecipesPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recipes);
        presenter=new MainRecipesPresenter(this);
    }
    public void setRecyclerBest(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.recycleRecipeBest);
        MainRecipesAdapter mainRecipesAdapter=new MainRecipesAdapter(recipes);
        mainRecipesAdapter.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainRecipesAdapter);
    }
    public void setRecyclerBreakfastLunch(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.recycleRecipeBreakfastLaunch);
        MainRecipesAdapter mainRecipesAdapter=new MainRecipesAdapter(recipes);
        mainRecipesAdapter.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainRecipesAdapter);
    }

    public void setRecyclerSweets(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.sweets);
        MainRecipesAdapter mainRecipesAdapter=new MainRecipesAdapter(recipes);
        mainRecipesAdapter.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainRecipesAdapter);
    }

    public void navigatetoCreateNewRecipe()
    {
        Intent intent=new Intent(this, NewRecipeActivity.class);
        startActivity(intent);
    }
    public void createRecipe(View view) {
presenter.ToCreateNewRecipeClicked();
    }
    @Override
    public void recipeClick(RecipeInformation recipe) {
        Intent intent = new Intent(this,RecipeActivity.class);
        startActivity(intent);
    }

    public void userprofile(View view) {
        Intent intent=new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
   @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item=men
        switch (item.getItemId()) {
            case R.id.:
                newGame();
                return true;
            case R.id.help:
                showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    
    }