setAndroid Messaging Hybrid Webapp Interface.

Creators Morgan Lemke Jimmy Wang
mlemke@liveperson.com
jwang@liveperson.com

The purpose of this interface is to allow customers to use HTML and Javascript on a webpage to call our messaging SDK in 
Android Native code.

You will still need the following.
-LivePerson Asyncronous Android SDK
-WebappInterface.java file
-access to any activity in order to pass it to the WebappInterface

Why would you use this?
-You use a hybrid app and mostly don't have access to the native code.
-You want to be able to update look and feel of messaging buttons without having to do an app release

Calls available are as follows

<script type="text/javascript">
    function startMessaging() {
        android.startMessaging();     
    }
    function toastTest() {
        android.toast();
    }
    function setName(first, last){
        android.setName(first,last);
    }
    function setPhone(phone){
        android.setPhone(phone);
    }
    function tellUser(message){
        android.tellUser;
    }
</script>

toastTest() is for testing this call with just make a toast notification appear in app.

tellUser() allows you to notifiy the user of anything you like in a toast notifiction, this has no interaction with the Messaging SDK