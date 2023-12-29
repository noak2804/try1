package com.example.theproject.RegisterSignIn.SignIn;

import com.example.theproject.RegisterSignIn.SignIn.SignInActivity;

public class SignInPresenter {
    SignInActivity view;

    public SignInPresenter(SignInActivity view) {
        this.view = view;
    }
    public void continueClicked()
    {
        view.navigatetoMainRecipes();
    }
    public void toRegister(){view.navigatetoRegister();}
}
