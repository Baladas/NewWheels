package ppe.ece.fr.newwheels;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Gilles on 08/03/2017.
 */

public class Social extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_page);

        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/communities/111332393786080098061"));
                startActivity(intent);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mobile.twitter.com/?locale=fr"));
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/NewWheels-134205607115288/"));
                startActivity(intent4);
                break;
        }
    }

}