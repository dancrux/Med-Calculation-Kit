package com.wordpress.cruxonlinedotblog.cruxbmicalc.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;


import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Adapters.ViewPagerAdapter;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.FirstFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.FourthFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.SecondFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.ThirdFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

public class BmiActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private StartAppAd startAppAd = new StartAppAd(this);


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "202986230", true);
        setContentView(R.layout.activity_bmi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting up the viewpager view
        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        adapter.AddFragment(new FirstFragment(), "BMI CALC");
        adapter.AddFragment(new SecondFragment(), "LENGTH CONVERTER");
        adapter.AddFragment(new ThirdFragment(), "WEIGHT CONVERTER");
        adapter.AddFragment(new FourthFragment(), "BMI CHART SUMMARY");

        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SENDTO);
                Email.setData(Uri.parse("mailto:"));
//            Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "FEEDBACK"); // Email 's Subject
//            Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
                if (Email.resolveActivity(getPackageManager())!=null){
                    startActivity(Intent.createChooser(Email, "Send Feedback From"));
                }
//            try {
//                startActivity(Intent.createChooser(Email, "Send Feedback From:"));
//            } catch (android.content.ActivityNotFoundException ex) {
//                Toast.makeText(BmiActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
//            }
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu =navigationView.getMenu();
        menu.findItem(R.id.nav_bmi).setChecked(true);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_share:
                Intent menuShare = new Intent(Intent.ACTION_SEND);

                menuShare.setType("text/plain");

                menuShare.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));

                startActivity(Intent.createChooser(menuShare, getString(R.string.share_header)));
                return true;
            case R.id.action_feedback:
                Intent Email = new Intent(Intent.ACTION_SENDTO);
                Email.setData(Uri.parse("mailto:"));
//            Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "FEEDBACK"); // Email 's Subject
//            Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
                if (Email.resolveActivity(getPackageManager())!=null){
                    startActivity(Intent.createChooser(Email, "Send Feedback From"));
                }
//            try {
//                startActivity(Intent.createChooser(Email, "Send Feedback From:"));
//            } catch (android.content.ActivityNotFoundException ex) {
//                Toast.makeText(BmiActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
//            }
                return true;
            case R.id.action_rate:
                rateApp();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

//            finish();


        }else {

            startActivity(new Intent(BmiActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startAppAd.onBackPressed();

        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id ==R.id.nav_home ) {
            startActivity(new Intent(BmiActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }else if (id == R.id.nav_cardiovascular){
            startActivity(new Intent(BmiActivity.this,CardiovascularActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }else if (id == R.id.nav_rate){
            rateApp();
        }else if (id == R.id.nav_share){
            Intent menuShare = new Intent(Intent.ACTION_SEND);

            menuShare.setType("text/plain");


            menuShare.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));

            startActivity(Intent.createChooser(menuShare, getString(R.string.share_header)));

        }else if (id == R.id.nav_respiratory){
            startActivity(new Intent(BmiActivity.this, RespiratoryActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }else if (id == R.id.nav_feedback){
            Intent Email = new Intent(Intent.ACTION_SENDTO);
            Email.setData(Uri.parse("mailto:"));
//            Email.setType("message/rfc822");
            Email.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
            Email.putExtra(Intent.EXTRA_SUBJECT,
                    "FEEDBACK"); // Email 's Subject
//            Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
            if (Email.resolveActivity(getPackageManager())!=null){
                startActivity(Intent.createChooser(Email, "Send Feedback From"));
            }
//            try {
//                startActivity(Intent.createChooser(Email, "Send Feedback From:"));
//            } catch (android.content.ActivityNotFoundException ex) {
//                Toast.makeText(BmiActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
//            }
            return true;
        }else if (id == R.id.nav_renal){
            startActivity(new Intent(BmiActivity.this,RenalActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startAppAd.showAd();
        }else if (id == R.id.nav_leanMass) {
            startActivity(new Intent(BmiActivity.this, LeanMassActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startAppAd.showAd();
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void rateApp() {
      Intent rateIntent = new Intent(Intent.ACTION_VIEW);
      rateIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.wordpress.cruxonlinedotblog.cruxbmicalc"));
      rateIntent.setPackage("com.android.vending");
      startActivity(rateIntent);
    }

}
