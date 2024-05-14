package com.example.theproject.NewRecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.Ingredients;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class NewRecipeActivity extends AppCompatActivity  {
    private static final int CAMERA_PIC_REQUEST = 1337;
    ArrayList <View>ingredientArray =new ArrayList<View>();
    EditText nameRecipe;
    Button deleteButton;
    EditText unit;
    EditText amount;
    TextInputEditText ingredient;
    ArrayList<Ingredients> ingredients;
    LinearLayout layout_ingredients;
    NewRecipePresenter presenter;
    TextView textView;

    EditText preparation;
    String category;
    String cookTime;
    RadioGroup radioCategory;
    RadioButton radioCategorySelected;
    ImageView imageView;
    Bitmap image;

    Button btnGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        presenter=new NewRecipePresenter(this);
        deleteButton=findViewById(R.id.delete_button);
        layout_ingredients=findViewById(R.id.ingerdientLayoutRecipe);
        ArrayList<Ingredients> ingredients=new ArrayList<Ingredients>(ingredientArray.size());
        unit=null;
        amount=null;
      ingredient =null;

        nameRecipe=findViewById(R.id.name);


        preparation=findViewById(R.id.preparation);

         btnGallery = findViewById(R.id.addPhotos);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent();
                iGallery.setType("*/*");
                iGallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(iGallery,2);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         imageView = findViewById(R.id.imageView);

        if (resultCode == RESULT_OK) {
            Uri temp = data.getData();
            Bitmap bitmap = null;

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), temp);

                image = bitmap;
                presenter.updateBitmap(bitmap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            imageView.setImageBitmap(image);
            imageView.setVisibility(View.VISIBLE);

            btnGallery.setVisibility(View.GONE);


        }
    }
    public void addIngredients(View view) {

       deleteButton.setVisibility(View.VISIBLE);
        final View view1 = getLayoutInflater().inflate(R.layout.ingredients_recycle_recipe, null);
        layout_ingredients.addView(view1);
        ingredientArray.add(view1);
    }

    public void submitNewRecipe(View view) {
        ingredients=new ArrayList<>();


        textView=findViewById(R.id.cook_time);
        cookTime=textView.getText().toString();

        radioCategory=(RadioGroup) findViewById(R.id.radioButton);

        int selectedId=radioCategory.getCheckedRadioButtonId();
        radioCategorySelected=(RadioButton) findViewById(selectedId);
        if(radioCategorySelected==null)
        {
            category=null;
        }
        else{
            category= radioCategorySelected.getText().toString();}

        boolean b=false;

        for(int i=0;i<ingredientArray.size();i++)
        {
            View v =  ingredientArray.get(i);
             ingredient =v.findViewById(R.id.nameIngred1);

            unit=v.findViewById(R.id.unit);
            amount=v.findViewById(R.id.amount);
            if(!Objects.requireNonNull(ingredient.getText()).toString().equals("")&&!amount.getText().toString().equals("")&&!unit.getText().toString().equals(""))
            {
                int a=Integer.parseInt(amount.getText().toString());
                Ingredients temp=new Ingredients(ingredient.getText().toString(),a,unit.getText().toString());
                ingredients.add(temp);
                b=true;
            }
            else {
                Toast.makeText(this,"one of the fields is empty1",Toast.LENGTH_LONG).show();
                b=false;

            }

        }
        if(b)
        {
            presenter.CreateNewRecipeClicked(nameRecipe.getText().toString(),ingredients,preparation.getText().toString(),category,cookTime);
        }
        else {
            Toast.makeText(this,"one of the fields is empty2",Toast.LENGTH_LONG).show();
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



}