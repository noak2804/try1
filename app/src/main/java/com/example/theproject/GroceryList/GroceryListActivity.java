package com.example.theproject.GroceryList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;

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
}