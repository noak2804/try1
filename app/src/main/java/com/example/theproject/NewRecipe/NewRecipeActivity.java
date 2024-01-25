package com.example.theproject.NewRecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.Ingredients;
import com.example.theproject.model.RecipeInformation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NewRecipeActivity extends AppCompatActivity {
ArrayList <View>ingredientArray =new ArrayList<View>();
String nameRecipe;
Button deleteButton;
TextView unit;
EditText amount;
ArrayList<Ingredients> ingredients;
    LinearLayout layout_ingredients;
    NewRecipePresenter presenter;
    TextView textView;
    String preparation;
    String category;
    Integer cookTime;

 //   private final int GALLERY_REQ_CODE = 1000;
  //  ImageView imgCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        presenter=new NewRecipePresenter(this);
        deleteButton=findViewById(R.id.delete_button);
        layout_ingredients=findViewById(R.id.ingerdientLayoutRecipe);
        ArrayList<Ingredients> ingredients=new ArrayList<Ingredients>(ingredientArray.size());

        textView=findViewById(R.id.preparation);
        preparation=textView.getText().toString();
textView=findViewById(R.id.cook_time);
cookTime=Integer.parseInt(textView.toString());

      /*  imgCamera=findViewById(R.id.imgCamera);
        Button btnGallery = findViewById(R.id.btnGallery);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera,CAMERA_REQ_CODE);
            }
        });*/

    }

    public void addIngredients(View view) {

       deleteButton.setVisibility(View.VISIBLE);
        final View view1 = getLayoutInflater().inflate(R.layout.ingredients_recycle_recipe, null);
        layout_ingredients.addView(view1);
        ingredientArray.add(view1);
    }

    public void submitNewRecipe(View view) {

        for(int i=0;i<ingredientArray.size();i++)
        {
          View v =  ingredientArray.get(i);
            textView=v.findViewById(R.id.nameIngred);
            nameRecipe=textView.getText().toString();
            unit=v.findViewById(R.id.unit);
            amount=v.findViewById(R.id.amount);
            int a=Integer.parseInt(amount.getText().toString());
           Ingredients temp=new Ingredients(nameRecipe.toString(),a,unit.toString());
           ingredients.add(temp);
        }
        textView=findViewById(com.android.car.ui.R.id.category);
        category=textView.getText().toString();
        presenter.CreateNewRecipeClicked(nameRecipe,ingredients,preparation,category,null,cookTime);
    }

    public void delete_button(View view) {
        ingredientArray.remove(ingredientArray.size()-1);
        layout_ingredients.removeViewAt(layout_ingredients.getChildCount()-1);
        if(ingredientArray.size()==0)
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_recipe) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipes, menu_recipe);
        return true;

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

    public void addPhoto(View view) {

    }
}