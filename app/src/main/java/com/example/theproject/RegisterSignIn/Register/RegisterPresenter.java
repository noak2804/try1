package com.example.theproject.RegisterSignIn.Register;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.example.theproject.RegisterSignIn.Register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPresenter {
    RegisterActivity view;
    private FirebaseAuth mAuth;

    public RegisterPresenter(RegisterActivity view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
    }

    public void createClicked(String email,String password)
    {



            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(view, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                view.navigatetoMainRecipes();

                            }

                            else {
                                Toast.makeText(view,"Sign In failed",Toast.LENGTH_LONG).show();

                            }
                        }
                    });



    }
}
