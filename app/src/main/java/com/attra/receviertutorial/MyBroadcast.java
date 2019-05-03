package com.attra.receviertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            Toast.makeText(context,"Network state change",Toast.LENGTH_LONG).show();
        }

        else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Toast.makeText(context,"Boot Completed",Toast.LENGTH_LONG).show();

        }


    }


}
