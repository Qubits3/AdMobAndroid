package com.example.admobandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        //Banner Ad ID
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //Interstitial Ad ID
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8024686626348837/7254479388");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void goToActivity2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}

//Application Ad ID
//ca-app-pub-8024686626348837~4576345150

//Main Activity Banner Ad ID
//ca-app-pub-8024686626348837/8752050426

//Main Activity Interstitial Ad ID
//ca-app-pub-8024686626348837/7254479388

//Banner test ID
//ca-app-pub-3940256099942544/6300978111

//Interstitial test ID
//ca-app-pub-3940256099942544/1033173712