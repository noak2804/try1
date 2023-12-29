package com.example.theproject.RegisterSignIn.Home;

public class HomePresenter
{
    MainActivity view;

    public HomePresenter(MainActivity view) {
        this.view = view;


    }
    public void signInClicked()
    {
       view.navigateToSignIn();
    }
    public void registerClicked(){view.navigateToRegister();}
}
