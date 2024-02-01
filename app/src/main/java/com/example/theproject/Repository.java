package com.example.theproject;

import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Repository {
        private static Repository instance;

        private Repository(){}
        public static Repository getInstance(){
                if(instance==null)
                {
                        instance=new Repository();
                }
                return instance;

        }
        public void addUser(User user)
        {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/"+ FirebaseAuth.getInstance().getUid());
                myRef.setValue(user);
        }
        public void createRecipe(RecipeInformation recipe)
        {
                if(recipe.getRecipeId().equals(""))
                {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("recipes/").push();
                        recipe.setRecipeId(myRef.getKey());
                        myRef.setValue(recipe);
                }
                else {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("recipes/"+recipe.getRecipeId());
                        myRef.setValue(recipe);
                }
        }
}
