package com.example.theproject.UserProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.MainRecipes.MainRecipesAdapter;
import com.example.theproject.NewRecipe.NewRecipeActivity;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

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
        intent.putExtra("recipeId",recipe.getRecipeId());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

    }
    public void navigatetoGroceryList()
    {
        Intent intent=new Intent(this, GroceryListActivity.class);
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

    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void groceryList(View view) {
        presenter.ToGroceryList();
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