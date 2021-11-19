package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Login.LoginIterface;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }


}