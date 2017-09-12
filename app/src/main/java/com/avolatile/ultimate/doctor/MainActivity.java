package com.avolatile.ultimate.doctor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView navview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Doctor");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        //adding listener here
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navview = (NavigationView) findViewById(R.id.navview);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                mDrawerLayout.closeDrawers();

                switch (item.getItemId()){

                    case R.id.support :
                        Intent intent = new Intent(getApplicationContext(), support.class);
                        startActivity(intent);
                        item.setChecked(true);
                        break;

                    case R.id.myprofile :
                        Intent intent1 = new Intent(getApplicationContext(), MyProfile.class);
                        startActivity(intent1);
                        item.setChecked(true);
                        break;

                    case R.id.mypriclinic :
                        Intent intent2 = new Intent(getApplicationContext(), MyPrimaryClinic.class);
                        startActivity(intent2);
                        item.setChecked(true);
                        break;

                    case R.id.outofoffice :
                        Intent intent3 = new Intent(getApplicationContext(),outofoffice.class);
                        startActivity(intent3);
                        break;



                    case R.id.referandearn :
                        Intent intent4 = new Intent(getApplicationContext(),ReferAndEarn.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //this will work when any item from action bar is clicked
    //used to open navigation drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // you can handle on click event for the options of navigation drawer here

        if(id == R.id.support){
            Intent intent = new Intent(this, support.class);
            startActivity(intent);
            return true;
        }
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
