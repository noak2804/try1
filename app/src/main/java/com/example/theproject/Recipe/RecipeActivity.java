
package com.example.theproject.Recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.GroceryList.GroceryListActivity;

public class RecipeActivity extends AppCompatActivity {
RecipePresenter presenter;
    TextView nameTextView,ingredients,preparation,type;
    public int counter;
    Button timer;
    TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        presenter=new RecipePresenter(this);
        nameTextView = findViewById(R.id.nameRecipe);
        nameTextView.setText("name");
        ingredients = findViewById(R.id.ingredients);
        ingredients.setText("something");
        preparation = findViewById(R.id.preparationRecipe);
        preparation.setText("first");
        type = findViewById(R.id.type);
        type.setText("lunch");



        timer= (Button) findViewById(R.id.timer);
        time= (TextView) findViewById(R.id.time);
        timer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(1000, 1000){
                    public void onTick(long millisUntilFinished){
                        time.setText(String.valueOf(counter));
                        counter++;
                    }
                    public  void onFinish(){
                        time.setText("FINISH!!");
                    }
                }.start();
            }
        });


        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingStars);
        Button submitButton = (Button) findViewById(R.id.sendRatingStars);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();*/
            }
        });
    }
    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void backToMainRecipe(View view) {
       presenter.BackClicked();
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