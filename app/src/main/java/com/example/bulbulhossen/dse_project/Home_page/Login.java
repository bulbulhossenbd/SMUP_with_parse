package com.example.bulbulhossen.dse_project.Home_page;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bulbulhossen.dse_project.Fragment.Main_fragment;
import com.example.bulbulhossen.dse_project.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Md.Bulbul Hossen on 11/12/15.
 */
public class Login extends AppCompatActivity {

    private EditText usernameView;
    private EditText passwordView;

    TextView signing_up,change_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signing_up = (TextView) findViewById(R.id.sign);
        signing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

        change_pass = (TextView) findViewById(R.id.forgetpassword);
        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Change_password.class);
                startActivity(intent);
            }
        });


        // start code parse

        // Set up the login form.
        usernameView = (EditText) findViewById(R.id.view);
        passwordView = (EditText) findViewById(R.id.view2);

        // Set up the submit button click handler
        findViewById(R.id.mainlogin_screen).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Validate the log in data
                boolean validationError = false;
                StringBuilder validationErrorMessage =
                        new StringBuilder(getResources().getString(R.string.error_intro));
                if (isEmpty(usernameView)) {
                    validationError = true;
                    validationErrorMessage.append(getResources().getString(R.string.error_blank_username));
                }
                if (isEmpty(passwordView)) {
                    if (validationError) {
                        validationErrorMessage.append(getResources().getString(R.string.error_join));
                    }
                    validationError = true;
                    validationErrorMessage.append(getResources().getString(R.string.error_blank_password));
                }
                validationErrorMessage.append(getResources().getString(R.string.error_end));

                // If there is a validation error, display the error
                if (validationError) {
                    Toast.makeText(Login.this, validationErrorMessage.toString(), Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                // Set up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(Login.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Logging in.  Please wait.");
                dlg.show();
                // Call the Parse login method
                ParseUser.logInInBackground(usernameView.getText().toString(), passwordView.getText()
                        .toString(), new LogInCallback() {

                    @Override
                    public void done(ParseUser user, ParseException e) {
                        dlg.dismiss();
                        if (e != null) {
                            // Show the error message
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            // Start an intent for the dispatch activity
                            Intent intent = new Intent(Login.this, DispatchActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }

        //end code parse












//
//
//
////        Main Menu
//
//
//
//        mainscreen = (TextView) findViewById(R.id.mainlogin_screen);
////
//        mainscreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
//                Intent mains = new Intent(Login.this,Main_fragment.class);
//                startActivity(mains);
//            }
//        });
//
//
//
//        //Login Underline
//
//        TextView textView = new TextView(this);
//        textView.setText(R.string.forget);
//        String tempString="Froget Password";
//
//        TextView text=(TextView)findViewById(R.id.forgetpassword);
//
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Login.this,Reset.class);
//                startActivity(intent);
//            }
//        });
//
//
//        SpannableString spanString = new SpannableString(tempString);
//        spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
//        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
//        spanString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString.length(), 0);
//        text.setText(spanString);
//
//
//        //Signup Underline
//
//        TextView textView_up = new TextView(this);
//        textView_up.setText(R.string.forget);
//        String tempString_up="Sign Up";
//
//
//        TextView tex_upt=(TextView)findViewById(R.id.sign);
//
//        tex_upt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(Login.this,Signup.class);
//                startActivity(intent2);
//            }
//        });
//
//
//        SpannableString spanStringup = new SpannableString(tempString_up);
//        spanStringup.setSpan(new UnderlineSpan(), 0, spanStringup.length(), 0);
//        spanStringup.setSpan(new StyleSpan(Typeface.BOLD), 0, spanStringup.length(), 0);
//        spanStringup.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanStringup.length(), 0);
//        tex_upt.setText(spanStringup);
//
//
//
//




    }
}
