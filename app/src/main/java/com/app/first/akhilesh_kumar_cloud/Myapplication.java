package com.app.first.akhilesh_kumar_cloud;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by akhilesh yadav on 6/5/2017.
 */

public class Myapplication extends Application {

    @Override
    public void onCreate(){

        super.onCreate();
        printHsesKey();
    }
    public void printHsesKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.app.first.akhilesh_kumar_cloud",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Myapplication", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
