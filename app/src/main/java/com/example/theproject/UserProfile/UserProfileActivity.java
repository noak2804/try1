package com.example.theproject.UserProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.MainRecipes.MainRecipesAdapter;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity  implements MainRecipesAdapter.RecipeClickListener {
UserProfilePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        presenter=new UserProfilePresenter(this);
    }
    public void setRecyclerMine(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.myRecipes);
        MainRecipesAdapter mainRecipesAdapter=new MainRecipesAdapter(recipes);
        mainRecipesAdapter.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainRecipesAdapter);
    }
    public void setRecyclerSaved(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.savedRecipes);
        MainRecipesAdapter mainRecipesAdapter=new MainRecipesAdapter(recipes);
        mainRecipesAdapter.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainRecipesAdapter);
    }

    @Override
    public void recipeClick(RecipeInformation recipe) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("name ",recipe.getName());
        startActivity(intent);
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