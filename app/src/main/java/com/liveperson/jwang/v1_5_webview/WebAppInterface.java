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
 * Last edited 2/24/2017
 * currently all functionality is working
 * please reach out to mlemke@liveperson.com for questions
 */

public class WebAppInterface extends MainActivity{
    Context mContext;
    Activity A;
    String appID;
    String BrandID;
    String phone;
    String nameFirst;
    String nameLast;


    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** All functions bellow designed to be called from the within
     * the app
     **/
    //initialize the Activity (pass by reference)
    public void setActivity(Activity mainA){
        A=mainA;
    }
    //set initial phone
    public void setInternalPhone(String phoneIn){
        phone=phoneIn;
    }
    //lets you set base values
    public void setAppValues(String appIDIn, String BrandIDIn) {
        appID=appIDIn;
        BrandID=BrandIDIn;
    }

    /** All functions bellow designed to be called from the webpage
     * be careful of inherient security risks
     **/

    //basically on click function
    @JavascriptInterface
    public void startMessaging(){
        //Toast.makeText(mContext, "trying to call", Toast.LENGTH_SHORT).show();
        LivePerson.showConversation(A);
    }
    //allows you to change name but everything must be repassed
    @JavascriptInterface
    public void setName(String nameFirstIn, String nameLastIn) {
        Toast.makeText(mContext, "Toast Test", Toast.LENGTH_SHORT).show();
        nameFirst=nameFirstIn;
        nameLast=nameLastIn;
        LivePerson.setUserProfile(appID,nameFirstIn,nameLastIn, phone);
    }
    //allows you to change phone but everything must be repassed
    @JavascriptInterface
    public void setPhone(String phoneIn) {
        phone=phoneIn;
        LivePerson.setUserProfile(appID,nameFirst,nameLast, phoneIn);
    }
    //just test function to call
    @JavascriptInterface
    public void toast(){
        Toast.makeText(mContext, "Toast Test", Toast.LENGTH_SHORT).show();
    }

    //lets you display to the user something has been done by showing a toast
    @JavascriptInterface
    public void tellUser(String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
