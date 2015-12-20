package com.example.bulbulhossen.dse_project.Home_page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bulbulhossen.dse_project.Fragment.Main_fragment;
import com.parse.ParseUser;

/**
 * Created by bulbul.hossen on 12/20/2015.
 */
public class DispatchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Check if there is current user info
        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            startActivity(new Intent(this, Main_fragment.class));
        } else {
            // Start and intent for the logged out activity
            startActivity(new Intent(this, Home.class));
        }
    }
}
