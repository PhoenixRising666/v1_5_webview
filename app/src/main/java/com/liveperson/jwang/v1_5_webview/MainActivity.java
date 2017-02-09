package com.liveperson.jwang.v1_5_webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.liveperson.jwang.v1_5_webview.push.RegistrationIntentService;
import com.liveperson.infra.InitLivePersonProperties;
import com.liveperson.infra.callbacks.InitLivePersonCallBack;
import com.liveperson.messaging.sdk.api.LivePerson;
import com.liveperson.messaging.sdk.api.callbacks.LogoutLivePersonCallback;

public class MainActivity extends AppCompatActivity {

    String BrandID = "13532285"; // Your LiveEngage account number
    String appID = "com.liveperson.jwang.v1_5_webview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

   /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        LivePerson.initialize(MainActivity.this, new InitLivePersonProperties(BrandID, appID, new InitLivePersonCallBack()
        {
            @Override
            public void onInitSucceed(){
                LivePerson.setUserProfile(appID, "Dr. Mister", "Strange maybe", "I have come to bargin");
                Intent intent = new Intent(MainActivity.this, RegistrationIntentService.class);
                startService(intent);
            }
            @Override
            public void onInitFailed(Exception e) {

            }
        }));


        Button showLogOutBtn = (Button) findViewById(R.id.log_out);
        showLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LivePerson.logOut(MainActivity.this, BrandID, appID, new LogoutLivePersonCallback() {
                    @Override
                    public void onLogoutSucceed() {

                    }

                    @Override
                    public void onLogoutFailed() {

                    }
                });
            }
        });

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.morganlemke.com/webview-test/");

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        //new interface called
        WebAppInterface myInterface= new WebAppInterface(this);
        //name it
        myWebView.addJavascriptInterface(myInterface, "Android");
        
        //pass the activity so it can be referenced
        myInterface.setAppValues(appID,BrandID);
        myInterface.setActivity(MainActivity.this);
        //pass default values


    }




/*
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
