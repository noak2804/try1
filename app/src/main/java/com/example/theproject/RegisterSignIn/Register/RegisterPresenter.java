package com.example.theproject.RegisterSignIn.Register;

import com.example.theproject.RegisterSignIn.Register.RegisterActivity;

public class RegisterPresenter {
    RegisterActivity view;

    public RegisterPresenter(RegisterActivity view) {
        this.view = view;
    }

    public void createClicked()
    {
        view.navigatetoMainRecipes();
    }
}
