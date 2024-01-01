package com.example.theproject.NewRecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.theproject.R;
import com.example.theproject.model.Ingredients;
import com.example.theproject.model.RecipeInformation;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NewRecipeActivity extends AppCompatActivity {
ArrayList <View>ingredientArray =new ArrayList<View>();
TextView nameRecipe;
Button deleteButton;
TextView unit;
EditText amount;
    LinearLayout layout_ingredients;
    NewRecipePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        presenter=new NewRecipePresenter(this);
        deleteButton=findViewById(R.id.delete_button);
         layout_ingredients=findViewById(R.id.ingerdientLayoutRecipe);


    }

    public void addIngredients(View view) {

       deleteButton.setVisibility(View.VISIBLE);
        final View view1 = getLayoutInflater().inflate(R.layout.ingredients_recycle_recipe, null);
        layout_ingredients.addView(view1);
        ingredientArray.add(view1);
    }

    public void submitNewRecipe(View view) {
        RecipeInformation recipeInformation;
        recipeInformation=new RecipeInformation("s","sdf","k");

        for(int i=0;i<ingredientArray.size();i++)
        {
          View v =  ingredientArray.get(i);
            nameRecipe=v.findViewById(R.id.nameIngred);
            unit=v.findViewById(R.id.unit);
            amount=v.findViewById(R.id.amount);
            int a=Integer.parseInt(amount.getText().toString());
           Ingredients temp=new Ingredients(nameRecipe.toString(),a,unit.toString());
           recipeInformation.addIng(temp);
        }

    }

    public void delete_button(View view) {
        ingredientArray.remove(ingredientArray.size()-1);
        layout_ingredients.removeViewAt(layout_ingredients.getChildCount()-1);
        if(ingredientArray.size()==0)
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }
}