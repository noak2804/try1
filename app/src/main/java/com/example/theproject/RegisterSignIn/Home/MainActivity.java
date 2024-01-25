package com.example.theproject.RegisterSignIn.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.RegisterSignIn.Home.HomePresenter;
import com.example.theproject.RegisterSignIn.Register.RegisterActivity;
import com.example.theproject.RegisterSignIn.SignIn.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    HomePresenter presenter;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new HomePresenter(this);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(this, MainRecipesActivity.class);
            startActivity(intent);
        }
    }

    public void navigateToSignIn()
    {
        Intent intent=new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
    public void signIn(View view) {

       presenter.signInClicked();
    }

    public void navigateToRegister()
    {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void reg(View view) {
        presenter.registerClicked();
    }


}