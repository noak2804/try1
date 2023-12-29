package com.example.theproject.RegisterSignIn.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;

public class RegisterActivity extends AppCompatActivity {
RegisterPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter=new RegisterPresenter(this);
    }

    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void createSubmit(View view) {
        presenter.createClicked();
    }
}