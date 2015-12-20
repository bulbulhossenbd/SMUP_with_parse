package com.example.bulbulhossen.dse_project.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.bulbulhossen.dse_project.All_adapter.FragmentDrawer;
import com.example.bulbulhossen.dse_project.Home_page.DispatchActivity;
import com.example.bulbulhossen.dse_project.R;
import com.parse.ParseUser;

/**
 * Created by Md.Bulbul Hossen on 11/12/15.
 */
public class Main_fragment extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{



    // decalre android lime toolbar object
    Toolbar androidlime_toolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        // linking with xml
        androidlime_toolbar = (Toolbar) findViewById(R.id.toolbar);
        // giving actionbar support
        setSupportActionBar(androidlime_toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), androidlime_toolbar);
        drawerFragment.setDrawerListener(this);

        if(savedInstanceState == null) {
            displayView(0);
        }

    }


    //back button

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.iconwa).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();
    }

    //back button end







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            ParseUser.getCurrentUser().logOut();
            startActivity(new Intent(Main_fragment.this, DispatchActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }
    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new Home_Web_update_Fragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new Update_Fragment();
                title = getString(R.string.title_updatemarket);
                break;
            case 2:
                fragment = new About_Fragment();
                title = getString(R.string.title_about);
                break;

            case 3:
                fragment = new Account_Fragment();
                title = getString(R.string.title_edit);
                break;
            default:
                fragment = new Home_Web_update_Fragment();
                title = getString(R.string.title_home);
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
