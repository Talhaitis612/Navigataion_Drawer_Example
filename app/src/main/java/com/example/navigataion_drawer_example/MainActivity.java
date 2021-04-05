package com.example.navigataion_drawer_example;
/*
* Navigation Drawer is a panel that displays App’s Navigation option from the left edge of the screen.
* It is one of the most important and useful UI pattern introduced by the Google for developing Android app.
*.Navigation drawer is a side menu that helps us to organise the navigation inside our app.
* It is a uniform way to access different pages and information inside our app. It is hidden most of the time
* but is revealed when we swipes from left edge of the screen or whenever we click on menu/app icon in the action bar.
*
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigationDrawer(); // call method
    }
//user defined fuction in which we override several methods
    private void setNavigationDrawer() {
        //getting refrence of the drawer layout
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
// implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//1.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener listener):
// This method is used to set a listener that will be notified when a menu item is selected.
//            Below we shows the code how to use this listener.


            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment frag = null; // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
// check selected menu item's id and replace a Fragment Accordingly
                //this condition checks the itemId set in the menu resource file
                //if it match then we set the frag variable to the matched fragment
                if (itemId == R.id.first) {
                    frag = new FirstFragment();
                } else if (itemId == R.id.second) {
                    frag = new SecondFragment();
                } else if (itemId == R.id.third) {
                    frag = new ThirdFragment();
                }
// display a toast message with menu item's title
//Toast display us the name of the menu we select
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });
    }
}
