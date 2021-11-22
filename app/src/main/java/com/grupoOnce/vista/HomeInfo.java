package com.grupoOnce.vista;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_info);
        getSupportActionBar().hide();


    }


    public void redirectionToLogin(View view) {
        Intent newView = new Intent(this, login.class);
        startActivity(newView);
        finish();
    }
}



