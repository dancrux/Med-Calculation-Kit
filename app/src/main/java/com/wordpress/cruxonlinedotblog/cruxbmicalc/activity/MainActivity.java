package com.wordpress.cruxonlinedotblog.cruxbmicalc.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Adapters.ViewPagerAdapter;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.FirstFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.FourthFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.SecondFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments.ThirdFragment;
import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;


public class MainActivity  extends AppCompatActivity {

    private InterstitialAd interstitial;

    private AdView adView;

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are You Sure You Want To Exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("NO!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        interstitial.loadAd(new AdRequest.Builder().build());




// Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-3062657192063025~1116403640");

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        adView = findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice() to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("ADMOB_ERROR_CODE","admob error code:"+ errorCode);
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        interstitial.setAdListener(new AdListener() {

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdLoaded() {

                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("INTERSTITIAL_ERROR"," interstitial error code:"+ errorCode);
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdClosed() {
    super.onAdClosed();
                Intent Email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "FEEDBACK"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
                try {
                    startActivity(Intent.createChooser(Email, "Send Feedback From:"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
                }
interstitial.loadAd(new AdRequest.Builder().build());
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (interstitial.isLoaded()) {
                    interstitial.show();

                }else {
                    Intent Email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                    Email.setType("message/rfc822");
                    Email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
                    Email.putExtra(Intent.EXTRA_SUBJECT,
                            "FEEDBACK"); // Email 's Subject
                    Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
                    try {
                        startActivity(Intent.createChooser(Email, "Send Feedback From:"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }




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
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            case R.id.action_share:
                Intent menuShare = new Intent(Intent.ACTION_SEND);

                menuShare.setType("text/plain");


                menuShare.putExtra(Intent.EXTRA_TEXT, "Know Your Bmi..Stay Healthy.. " +
                        "Get The Crux BmiCalc With a Length and Weight Unit Converter  Today ..Google playStore...https://play.google.com/store/apps/details?id=com.wordpress.cruxonlinedotblog.cruxbmicalc");

                startActivity(Intent.createChooser(menuShare, "Share Crux BmiCalc With"));
                return true;
            case R.id.action_feedback:
                Intent Email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"thecruxrepublic@gmail.com"});  //developer 's email//
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "FEEDBACK"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Admin," + "");  //Email 's Greeting text//
                try {
                    startActivity(Intent.createChooser(Email, "Send Feedback From:"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "No email client installed.", Toast.LENGTH_LONG).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */


    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null ) {
            adView.resume();



        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }


}


