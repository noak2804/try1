
package com.example.theproject.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
    private final int interval = 1000; // 1 Second
    private Handler handler = new Handler();
    private Runnable runnable;
    ArrayList<Ingredients> ingredientArray;
    TextView ingredients;
    public int counter;
    RecipeInformation recipe;
    Button timer;
    TextView time;
    RatingBar ratingbar;
    Button submitButton;
    String recipeId;
    String userId;
    User user;
    Button saveRecipe;
    Button groceryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        presenter=new RecipePresenter(this);

        groceryList=(Button) findViewById(R.id.addgroceryList);


groceryList.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        groceryList.setBackgroundResource(R.drawable.border_text);
    }
});





        submitButton = (Button) findViewById(R.id.sendRatingStars);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingbar=(RatingBar)findViewById(R.id.ratingStars);

                String rating=String.valueOf(ratingbar.getRating());

                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setUi(RecipeInformation recipe){
        String s="";
        nameTextView = findViewById(R.id.nameRecipe);
        nameTextView.setText(recipe.getName());
       ingredients=findViewById(R.id.ingredients);
       ingredientArray=recipe.getIngredientArray();
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
        timer= (Button) findViewById(R.id.timer);




        timer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView t = (TextView) findViewById(R.id.time);
                        t.setText(String.valueOf(counter));

                        counter--;
                    }
                });
            }
        });


    }
    public void TextViewToString(Integer num)
    {
        time.setText(String.valueOf(num));
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
    public void addGroceryList(View view) {
        presenter.addGroceryListClicked();
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
        ImageView imageView=findViewById(R.id.imageViewSave);
        imageView.setImageDrawable(getDrawable(R.drawable.saved));

       presenter.SaveRecipe();
    }
}