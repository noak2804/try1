package com.example.theproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.example.theproject.model.RecipeInformation;
import com.example.theproject.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
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
        public interface LoadRecipePicListener {
                void updateTvShowPic(Bitmap bitmap, String id);
        }
        LoadRecipePicListener loadRecipePicListener;

        public void setLoadRecipePicListener(LoadRecipePicListener loadProductPicListener) {
                this.loadRecipePicListener = loadRecipePicListener;
        }

        public void addRecipePic(Bitmap bitmap, String id) {
                StorageReference storageRef = FirebaseStorage.getInstance().getReference();
                StorageReference mountainImagesRef = storageRef.child("recipe/" + id + ".jpg");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainImagesRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {

                        }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                });
        }

        public void loadRecipePic(String id) {
                StorageReference storageRef = FirebaseStorage.getInstance().getReference();
                StorageReference islandRef = storageRef.child("recipe/" + id + ".jpg");

                final long ONE_MEGABYTE = 1024 * 1024;
                islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                                Bitmap compressedBitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                loadRecipePicListener.updateTvShowPic(compressedBitmap,id);
                        }
                }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                                // Handle any errors
                        }
                });

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

