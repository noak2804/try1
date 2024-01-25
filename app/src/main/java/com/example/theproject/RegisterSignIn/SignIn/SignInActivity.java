package com.example.theproject.RegisterSignIn.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.RegisterSignIn.Register.RegisterActivity;

public class SignInActivity extends AppCompatActivity {

    SignInPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        presenter=new SignInPresenter(this);
    }

    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void signInSubmit(View view) {
        EditText email = findViewById(R.id.signInEmailAddress);
        EditText password = findViewById(R.id.loginPassword);

        presenter.continueClicked(email.getText().toString(),password.getText().toString());
    }
    public void navigatetoRegister()
    {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void toReg(View view) {
        presenter.toRegister();
    }
}