package com.example.theproject.MainRecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.NewRecipe.NewRecipeActivity;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainRecipesActivity extends AppCompatActivity implements MainRecipesAdapter.RecipeClickListener {

    MainRecipesPresenter presenter;
    private MainRecipesAdapter adapter1;
    private MainRecipesAdapter adapter2;
    private MainRecipesAdapter adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recipes);
        presenter=new MainRecipesPresenter(this);


        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String queryString) {
                adapter1.getFilter().filter(queryString);
                adapter2.getFilter().filter(queryString);

                adapter3.getFilter().filter(queryString);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryString) {
                adapter1.getFilter().filter(queryString);
                adapter2.getFilter().filter(queryString);

                adapter3.getFilter().filter(queryString);
                return false;
            }
        });

    }
    public void setRecyclerBest(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.recycleRecipeBest);
        adapter1=new MainRecipesAdapter(recipes);
        adapter1.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter1);
    }
    public void setRecyclerBreakfastLunch(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.recycleRecipeBreakfastLaunch);
        adapter2 =new MainRecipesAdapter(recipes);
        adapter2.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter2);
    }

    public void setRecyclerSweets(ArrayList<RecipeInformation> recipes)
    {
        RecyclerView recyclerView=findViewById(R.id.sweets);
        adapter3=new MainRecipesAdapter(recipes);
        adapter3.setRecipeClickListener(this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter3);
    }
    public void addBitmap(Bitmap bitmap, String id) {
        adapter1.addBitmap(bitmap,id);
        adapter1.notifyDataSetChanged();

        adapter2.addBitmap(bitmap,id);
        adapter2.notifyDataSetChanged();

        adapter3.addBitmap(bitmap,id);
        adapter3.notifyDataSetChanged();
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


    @Override
    public void recipeClick(RecipeInformation recipe) {
        Intent intent = new Intent(this,RecipeActivity.class);
        intent.putExtra("recipeId",recipe.getRecipeId());
        startActivity(intent);
    }


   @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

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