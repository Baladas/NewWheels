package ppe.ece.fr.newwheels;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Gilles on 08/03/2017.
 */

public class Stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);

        BluetoothArduinoHelper mBlue = BluetoothArduinoHelper.getInstance("PNGFramework");

        try {
            mBlue.Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String msg = mBlue.getLastMessage();
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }



}