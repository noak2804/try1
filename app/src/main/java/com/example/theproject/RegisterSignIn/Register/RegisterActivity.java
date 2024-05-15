package com.example.theproject.RegisterSignIn.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.theproject.MainRecipes.MainRecipesActivity;
import com.example.theproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
RegisterPresenter presenter;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter=new RegisterPresenter(this);
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

    public void navigatetoMainRecipes()
    {
        Intent intent=new Intent(this, MainRecipesActivity.class);
        startActivity(intent);
    }
    public void createSubmit(View view) {
        EditText email = findViewById(R.id.registerEmailAddress);
        EditText password = findViewById(R.id.registerPassword);
        EditText name = findViewById(R.id.fullName);
        EditText phone = findViewById(R.id.phone);

        if(!email.getText().toString().equals("")&&!password.getText().toString().equals("")&&!name.getText().toString().equals("")&&!phone.getText().toString().equals(""))
        {
            presenter.createClicked(name.getText().toString(),email.getText().toString(),Integer.parseInt(phone.getText().toString()),password.getText().toString());
        }

        else{
            Toast.makeText(this,"one of the fields is empty",Toast.LENGTH_LONG).show();
        }
    }
}