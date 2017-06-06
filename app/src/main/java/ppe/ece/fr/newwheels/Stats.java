package ppe.ece.fr.newwheels;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Gilles on 08/03/2017.
 */

public class Stats extends AppCompatActivity {

    TextView textv;

    String msg;

    BluetoothArduinoHelper mBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);

        textv = (TextView) findViewById(R.id.textView10);

        mBlue = BluetoothArduinoHelper.getInstance(/*"PNGFramework"*/"BLUETOOTH HC-05");

        try {
            mBlue.Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Handler handler = new Handler();
        SocketThread thread = new SocketThread(handler);
        thread.start();

    }

    class SocketThread extends Thread {
        private final Handler mHandler;

        SocketThread(Handler handler){
            mHandler = handler;
        }
        @Override
        public void run(){
            msg = mBlue.getLastMessage();

            if (msg != "") {
                textv.setText(msg);
            } else {
                textv.setText("Waiting for arduino");
            }
        }
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }



}