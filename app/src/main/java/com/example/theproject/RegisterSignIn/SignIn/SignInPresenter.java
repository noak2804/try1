package com.example.theproject.RegisterSignIn.SignIn;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.theproject.RegisterSignIn.SignIn.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInPresenter {
    SignInActivity view;
    private FirebaseAuth mAuth;
    public SignInPresenter(SignInActivity view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
    }
    public void continueClicked(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(view, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            view.navigatetoMainRecipes();
                        }
                        else {
                            Toast .makeText(view,"Registeration failed",Toast.LENGTH_LONG).show();

                        }
                    }
                });


    }
    public void toRegister(){view.navigatetoRegister();}
}
