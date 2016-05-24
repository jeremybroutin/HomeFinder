package com.homefinder.jeremybroutin.homefinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.homefinder.jeremybroutin.homefinder.adapter.AdsListingAdapter;
import com.homefinder.jeremybroutin.homefinder.model.Listing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AdsListingAdapter mainAdapter = new AdsListingAdapter(this, getRowItems());
        ListView listView = (ListView) findViewById(R.id.listing);
        listView.setAdapter(mainAdapter);
    }

    // Helper function
    private List<Object> getRowItems(){
        List<Object> rowItems = new ArrayList<Object>();
        rowItems.add(new Listing(
                "North 12th Street (log in for details)",
                "House for Sale",
                "1,700 sq. ft, duplex 4 BR, 2.5 baths, backyard, parking in front",
                "$1500/mo",
                R.drawable.house1
        ));
        rowItems.add(new Listing(
                "166 North 7th Street (bet. Bedford & Driggs)",
                "Apartment for Sale",
                "1,320 sq. ft, 3 BR, 2 baths, gym, garage in building, doorman",
                "$1,220,000",
                R.drawable.house2
        ));

        // add generic 30 items
        for(int i = 2; i<32; i++){
            rowItems.add(makeListing(i));
        }

        return rowItems;
    }

    // Generate a sample listing
    private Listing makeListing(int number){
        int mod = number % 3;
        int resource;

        if(mod == 0){
            resource = R.drawable.house1;
        } else if(mod == 1){
            resource = R.drawable.house2;
        } else {
            resource = R.drawable.house3;
        }

        return new Listing(
                String.format("Generic listing #%d", number),
                "House for rent",
                "1,000 sq. ft, 2/2 with 2-car garage!",
                "$2800/mo",
                resource
        );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.new_york) {
            // Handle the camera action
        } else if (id == R.id.san_fra) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
