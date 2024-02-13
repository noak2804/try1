package com.example.theproject;

import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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
        //ממשק לקריאה למשתמש
        public interface LoadUserListener{
                void updateUser(User user);
        }
        LoadUserListener loadUserListener;


        public void setLoadUserListener(LoadUserListener loadUserListener) {
                this.loadUserListener = loadUserListener;
        }
        //ממשק לקיראה למתכון
        public interface LoadRecipesListener{
                void updateRecipes(ArrayList<RecipeInformation> recipes);
        }
        LoadRecipesListener loadRecipesListener;

        public void setLoadRecipesListener(LoadRecipesListener loadRecipesListener) {
                this.loadRecipesListener = loadRecipesListener;
        }
        public void addUser(User user)
        {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/"+ FirebaseAuth.getInstance().getUid());
                myRef.setValue(user);
        }
        public void updateUser(User user)
        {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/"+user.getId());
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

        public void readUser(String id){
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + id);
                myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                                User value = dataSnapshot.getValue(User.class);
                                loadUserListener.updateUser(value);

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                });
        }
        public void readRecipes(){
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("recipes");
                myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                ArrayList<RecipeInformation> recipes = new ArrayList<>();
                                for (DataSnapshot recipeSnapshot: dataSnapshot.getChildren()) {
                                        recipes.add(recipeSnapshot.getValue(RecipeInformation.class));
                                }
                                loadRecipesListener.updateRecipes(recipes);

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                });
        }
}

