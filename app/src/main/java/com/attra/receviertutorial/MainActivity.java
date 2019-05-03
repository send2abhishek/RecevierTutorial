package com.attra.receviertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBroadcast broadcast;

    private BroadcastReceiver mrecevier=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String data=intent.getStringExtra("Send");

            Toast.makeText(MainActivity.this,"msg from sender- "+ data,Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter=new IntentFilter("com.attra.receviertutorial.ACTION_SEND");
        registerReceiver(mrecevier,filter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mrecevier);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcast=new MyBroadcast();


    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcast,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void sendBrodcast(View view) {

        Intent intent=new Intent("com.attra.receviertutorial.ACTION_SEND");
        intent.putExtra("Send","Message From Sender");
        sendBroadcast(intent);
    }
}
