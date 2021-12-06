package com.grupoOnce.vista;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        passView();
    }




    public void passView() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                destroyMain();
            }
        }, 5000);
    }
    public void destroyMain() {
        Intent newView = new Intent(this, HomeInfo.class);
        startActivity(newView);
        finish();
    }

}
