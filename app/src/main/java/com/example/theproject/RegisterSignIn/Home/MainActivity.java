package com.example.theproject.RegisterSignIn.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theproject.R;
import com.example.theproject.Recipe.RecipeActivity;
import com.example.theproject.RegisterSignIn.Home.HomePresenter;
import com.example.theproject.RegisterSignIn.Register.RegisterActivity;
import com.example.theproject.RegisterSignIn.SignIn.SignInActivity;

public class MainActivity extends AppCompatActivity {
    HomePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new HomePresenter(this);

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