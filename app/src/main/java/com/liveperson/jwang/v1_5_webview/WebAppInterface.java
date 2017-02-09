package com.liveperson.jwang.v1_5_webview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.liveperson.messaging.sdk.api.LivePerson;

/**
 * Created by mlemke on 2/9/17.
 */

public class WebAppInterface extends MainActivity{
    Context mContext;
    Activity A;
    String appID;
    String BrandID;


    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    //initialize the Activity (pass by reference)
    public void setActivity(Activity mainA){
        A=mainA;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
/*    public void showToast(String toast) {
        //Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }*/

    public void startMessaging(){
        //Toast.makeText(mContext, "trying to call", Toast.LENGTH_SHORT).show();
        LivePerson.showConversation(A);
    }

    public void setName(String nameFirstIn,String nameLastIn){
        Toast.makeText(mContext, "trying to call", Toast.LENGTH_SHORT).show();
        LivePerson.setUserProfile(appID,nameFirstIn,nameLastIn,"858-926-8138");
    }

    public void toast(){
        Toast.makeText(mContext, "test call", Toast.LENGTH_SHORT).show();
    }

    public void setAppValues(String appIDIn, String BrandIDIn) {
        appID=appIDIn;
        BrandID=BrandIDIn;
    }
}
