package com.example.bulbulhossen.dse_project.Home_page;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bulbulhossen.dse_project.R;

/**
 * Created by Md.Bulbul Hossen on 11/12/15.
 */
public class Home extends AppCompatActivity {

    Intent intent,intent_2;
    TextView sign,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);






        //start code parse


        // Log in button click handler
        ((TextView) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Starts an intent of the log in activity
                startActivity(new Intent(Home.this, Login.class));
            }
        });

        // Sign up button click handler
        ((TextView) findViewById(R.id.signup)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Starts an intent for the sign up activity
                startActivity(new Intent(Home.this, Signup.class));
            }
        });


        // end code parse





//        login = (TextView) findViewById(R.id.login);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent_2 = new Intent(Home.this,Login.class);
//                startActivity(intent_2);
//
//            }
//        });
//
//
//
////        Sign UP
//        sign = (TextView) findViewById(R.id.signup);
//        sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent = new Intent(Home.this, Signup.class);
//                startActivity(intent);
//
//            }
//        });









    }
}
