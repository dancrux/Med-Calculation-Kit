package com.wordpress.cruxonlinedotblog.cruxbmicalc.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.startapp.android.publish.ads.banner.Banner;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AutoInterstitialPreferences;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CardView respiratoryCard, cardiovascularCard, renalCard, bmiCalcCard,leanMassCard;

    private StartAppAd startAppAd = new StartAppAd(this);

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "202986230", true);
//        StartAppAd.enableAutoInterstitial();
//        StartAppAd.setAutoInterstitialPreferences(
//                new AutoInterstitialPreferences()
//                        .setSecondsBetweenAds(120)
//                        .setActivitiesBetweenAds(3)
//        );

        setContentView(R.layout.activity_main1);

//        Banner banner = (com.startapp.android.publish.ads.banner.Banner) findViewById(R.id.startAppBanner);
//        banner.showBanner();
        CardView bmiCalcCard = findViewById(R.id.bmi_calc_card);

        CardView respiratoryCard = findViewById(R.id.respiratoryCard);
        CardView cardiovascularCard = findViewById(R.id.cardiovascularCard);
        CardView renalCard = findViewById(R.id.renal_card);
        CardView leanMassCard = findViewById(R.id.leanMassCard);

        bmiCalcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBmiCalc();

            }
        });
        respiratoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRespiratory();
            }
        });
        cardiovascularCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAppAd.showAd(new AdDisplayListener() {
                    @Override
                    public void adHidden(Ad ad) {
                        startActivity(new Intent(MainActivity.this,CardiovascularActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                    }

                    @Override
                    public void adDisplayed(Ad ad) {

                    }

                    @Override
                    public void adClicked(Ad ad) {

                    }

                    @Override
                    public void adNotDisplayed(Ad ad) {
                        startActivity(new Intent(MainActivity.this,CardiovascularActivity.class));
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                    }
                });

//                startActivity(new Intent(MainActivity.this,CardiovascularActivity.class));
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//                startAppAd.showAd();
            }
        });

        renalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this ,RenalActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
        leanMassCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAppAd.showAd(new AdDisplayListener() {
                    @Override
                    public void adHidden(Ad ad) {
                        startActivity(new Intent(MainActivity.this , LeanMassActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                    }

                    @Override
                    public void adDisplayed(Ad ad) {

                    }

                    @Override
                    public void adClicked(Ad ad) {

                    }

                    @Override
                    public void adNotDisplayed(Ad ad) {
                        startActivity(new Intent(MainActivity.this , LeanMassActivity.class));
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                    }
                });



            }

        });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
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
                }else{
                    Toast.makeText(MainActivity.this,"No email client Installed.", Toast
                    .LENGTH_SHORT).show();
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
        menu.findItem(R.id.nav_home).setChecked(true);

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

    private void openRespiratory() {
        startActivity(new Intent(MainActivity.this, RespiratoryActivity.class));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void openBmiCalc(){
        Intent bmiIntent = new Intent(this, BmiActivity.class);
        startActivity(bmiIntent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
                }else{
                    Toast.makeText(MainActivity.this,"No email client Installed.", Toast
                            .LENGTH_SHORT).show();
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
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("If You Enjoyed The App Please Leave a Rating At The Play Store. \n\n" +
                    "Do You Want To Exit ?");
            builder.setCancelable(true);
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                    finish();

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
//        if (id ==R.id.nav_home ) {
//            startActivity(new Intent(MainActivity.this, MainActivity.class));
//            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        if (id == R.id.nav_cardiovascular) {
            startActivity(new Intent(MainActivity.this, CardiovascularActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        } else if (id == R.id.nav_rate) {
            rateApp();
        } else if (id == R.id.nav_share) {
            Intent menuShare = new Intent(Intent.ACTION_SEND);

            menuShare.setType("text/plain");


            menuShare.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));

            startActivity(Intent.createChooser(menuShare, getString(R.string.share_header)));

        } else if (id == R.id.nav_respiratory) {
            startActivity(new Intent(MainActivity.this, RespiratoryActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        } else if (id == R.id.nav_bmi) {
            startActivity(new Intent(MainActivity.this, BmiActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        } else if (id == R.id.nav_renal) {
            startActivity(new Intent(MainActivity.this, RenalActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        } else if (id == R.id.nav_leanMass){
            startActivity(new Intent(MainActivity.this, LeanMassActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startAppAd.showAd();
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
            }else{
                Toast.makeText(MainActivity.this,"No email client Installed.", Toast
                        .LENGTH_SHORT).show();
            }
//            try {
//                startActivity(Intent.createChooser(Email, "Send Feedback From:"));
//            } catch (android.content.ActivityNotFoundException ex) {
//                Toast.makeText(BmiActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
//            }
            return true;
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



//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

}

