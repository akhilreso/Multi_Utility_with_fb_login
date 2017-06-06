package com.app.first.akhilesh_kumar_cloud;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by akhilesh yadav on 6/4/2017.
 */

public class connectionCheck {
    Context context;

    public  connectionCheck(Context context){

        this.context=context;
    }
    public boolean isConnected(){

        ConnectivityManager connectivity=(ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivity!=null){

            NetworkInfo info=connectivity.getActiveNetworkInfo();
            if (info !=null){

                if (info.getState()==NetworkInfo.State.CONNECTED){

                    return true;

                }

            }
        }
        return false;
    }
}
