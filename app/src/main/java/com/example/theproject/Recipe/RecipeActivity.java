
package com.example.theproject.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.NewRecipe.NewRecipeActivity;
import com.example.theproject.R;
import com.example.theproject.GroceryList.GroceryListActivity;
import com.example.theproject.RegisterSignIn.Home.MainActivity;
import com.example.theproject.Repository;
import com.example.theproject.UserProfile.UserProfileActivity;
import com.example.theproject.model.Ingredients;
import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RecipeActivity extends AppCompatActivity {
    RecipePresenter presenter;
    TextView nameTextView,preparation,type;
    ArrayList<Ingredients> ingredientArray;
    TextView t;
    TextView ingredients;
    public int counter;
    RecipeInformation recipe;
    RatingBar ratingbar;
    Button submitButton;
    ImageView groceryList;
    ImageView timerclicked;
    CountDownTimer c;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        presenter=new RecipePresenter(this);

        groceryList= findViewById(R.id.addgroceryList);
        timerclicked=findViewById(R.id.timer);
        restart=findViewById(R.id.restart);






        submitButton = (Button) findViewById(R.id.sendRatingStars);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingbar=(RatingBar)findViewById(R.id.ratingStars);

                String rating=String.valueOf(ratingbar.getRating());
                Double rate=Double.parseDouble(rating) ;
                presenter.ratingArray(rate);
                presenter.average();

                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });

    }
    public void addBitmap(Bitmap bitmap) {
        ImageView imageView=findViewById(R.id.bitmapRecipe);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageBitmap(bitmap);


    }

    public void setUi(RecipeInformation recipe,User user){
        this.recipe=recipe;
        Boolean b=false;
        for (int i=0;i<user.getRecipesArray().size();i++)
        {
            if(user.getRecipesArray().get(i).getRecipeId().equals(recipe.getRecipeId()))
            {
                groceryList.setImageDrawable((getDrawable(R.drawable.check)));
                b=true;
            }

        }
        if(b==false){
            groceryList.setImageDrawable((getDrawable(R.drawable.plus)));
        }

        ImageView imageView=findViewById(R.id.imageViewSave);

        if(user.getSavedRecipes().contains(recipe.getRecipeId())){
            imageView.setImageDrawable(getDrawable(R.drawable.saved));
        }
        else{
            imageView.setImageDrawable(getDrawable(R.drawable.savepicture));
        }



        nameTextView = findViewById(R.id.nameRecipe);
        nameTextView.setText("Recipe"+": "+recipe.getName());
        nameTextView.setFontFeatureSettings("serif");
       ingredients=findViewById(R.id.ingredients);
       ingredientArray=recipe.getIngredientArray();
        String s="";
       for(int i=0;i<ingredientArray.size();i++)
       {
            s+=ingredientArray.get(i).getIngredients()+" "+ingredientArray.get(i).getAmount()+" "+ingredientArray.get(i).getUnit()+"\n";

       }
       ingredients.setText(s);
        preparation = findViewById(R.id.preparationRecipe);
        preparation.setText(recipe.getPreparation());
        type = findViewById(R.id.type);
        type.setText(recipe.getCategory());

        counter=recipe.getCookTime();


    }

    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
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
    public void logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
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


    public void saveRecipe(View view) {
        presenter.SaveRecipe();

    }

    public void timerclick(View view) {
        final int minute=counter;
        counter=minute*60;
        c = new CountDownTimer(minute * 60000, 1000) {
            @Override
            public void onTick(long l) {
                timerclicked.setVisibility(View.INVISIBLE);
                restart.setVisibility(View.VISIBLE);
                t = (TextView) findViewById(R.id.time);
                int minutesLeft = (int) l / 60000; // Convert remaining milliseconds to minutes
                int secondsLeft = (int) (l % 60000) / 1000; // Convert remaining milliseconds to seconds
                t.setText(String.format("%02d:%02d", minutesLeft, secondsLeft));


                counter--;
            }

            @Override
            public void onFinish() {
                timerclicked.setVisibility(View.VISIBLE);
                t.setText("Finished");
            }
        };c.start();

    }

    public void restart(View view) {
        c.cancel();
        c.start();
    }

    public void addGroceryList(View view) {
        presenter.addGroceryListClicked();
    }
}