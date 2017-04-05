package ppe.ece.fr.newwheels;

import android.content.Intent;
import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Gilles on 08/03/2017.
 */

public class Scorepage extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    TextView tv;

    String textview = null;
    static JSONObject jObj ;
    static String json = "";

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /*static final String DB_URL = "jdbc:mysql://35.157.16.43:3306/sql11167574";

    static final String USER = "sql11167574";
    static final String PASS = "7IadPR2iSf";*/

    static final String DB_URL = "jdbc:mysql://10.0.0.2:3306/newwheels";

    static final String USER = "root";
    static final String PASS = "";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);

        tv = (TextView) findViewById(R.id.textView3);
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);

        Connection conn = null;
        Statement stmt = null;


        tv.setText("0");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT Amount FROM fonds";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                tv.setText(rs.getString("Amount"));

            }rs.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            tv.setText("2600");
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
            tv.setText("3");
        }

    }
    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }


    @Override
    public void onClick(View v) {

    }
}