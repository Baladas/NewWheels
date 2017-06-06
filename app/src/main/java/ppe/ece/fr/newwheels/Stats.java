package ppe.ece.fr.newwheels;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gilles on 08/03/2017.
 */

public class Stats extends AppCompatActivity {

    TextView textv;
    TextView textvvitesse;
    TextView textvdistance;
    ImageView myimage;

    public final String TAG = "Main";

    private Bluetooth bt;

    String msg;

    int vit1=0;
    int vit2=0;

    /*BluetoothArduinoHelper mBlue;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);

        textv = (TextView) findViewById(R.id.textView10);
        textvvitesse = (TextView) findViewById(R.id.textView7);
        textvdistance = (TextView) findViewById(R.id.textView4);
        myimage = (ImageView) findViewById(R.id.imageView3);
        textvdistance.setVisibility(View.INVISIBLE);

        /*mBlue = BluetoothArduinoHelper.getInstance("PNGFramework");

        try {
            mBlue.Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*Handler handler = new Handler();
        SocketThread thread = new SocketThread(handler);
        thread.start();*/

        bt = new Bluetooth(this, mHandler);
        connectService();

    }

    /*class SocketThread extends Thread {
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
    }*/


    public void connectService(){

        try {

            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

            if (bluetoothAdapter.isEnabled()) {

                bt.start();

                bt.connectDevice("HC-05");

                Log.d(TAG, "Btservice started - listening");


            } else {

                Log.w(TAG, "Btservice started - bluetooth is not enabled");


            }

        } catch(Exception e){

            Log.e(TAG, "Unable to start bt ",e);


        }

    }



    private final Handler mHandler = new Handler() {

        @Override

        public void handleMessage(Message msg) {

            switch (msg.what) {

                /*case Bluetooth.MESSAGE_STATE_CHANGE:

                    Log.d(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                    doUpdate("1");

                    break;

                case Bluetooth.MESSAGE_WRITE:

                    Log.d(TAG, "MESSAGE_WRITE ");
                    doUpdate("2");

                    break;*/

                case Bluetooth.MESSAGE_READ:

                    Log.d(TAG, "MESSAGE_READ ");
                    //doUpdate(String.valueOf(msg));
                    //doUpdate(String.valueOf(msg.arg2));
                    //doUpdate(String.valueOf(msg.obj));
                    //doUpdate(msg.toString());

                    /*byte[] bytes = ((byte[]) msg.obj);
                    String s = new String(bytes);
                    doUpdate(s);*/

                    /*byte[] bytes = ((byte[]) msg.obj);
                    String s = new String(bytes, 0, ((byte) msg.arg1));
                    doUpdate(s);*/

                    byte[] bytes = ((byte[]) msg.obj);
                    String s = new String(bytes, 0, msg.arg1);
                    doUpdate(s);

                    break;

                /*case Bluetooth.MESSAGE_DEVICE_NAME:

                    Log.d(TAG, "MESSAGE_DEVICE_NAME "+msg);
                    doUpdate("4");

                    break;

                case Bluetooth.MESSAGE_TOAST:

                    Log.d(TAG, "MESSAGE_TOAST "+msg);
                    doUpdate(String.valueOf(msg));

                    break;*/

            }

        }

    };

    public void doUpdate(String mymessage) {
        //textv.setText(mymessage);
        //String[] mastring = mymessage.split("@");
        //vit2= Integer.parseInt(mymessage);
        textvvitesse.setText("Speed :          "+mymessage+" Km/h");
        //textvdistance.setText("Distance :      "+mastring[0]+" m");


        if (!(mymessage.contains("6"))){
            myimage.setVisibility(View.VISIBLE);
        }else {
            myimage.setVisibility(View.INVISIBLE);
        }

       // vit1=vit2;

    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }

}