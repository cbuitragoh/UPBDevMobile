package com.grupoOnce.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

//public class login implements LoginIterface.loginController {

    private final LoginIterface.loginView view;

    public login(LoginIterface.loginView view) {
        this.view = view;
    }

    public Boolean loginVal(String editText, String indicator) {
        if (indicator.equals("editUsuario")) {
            if (editText.trim().isEmpty()) {
                view.resVal(indicator, "Los campos no pueden estar vacíos");
                return false;
            }
            } else if (indicator.equals("editPassword")) {
                if (editText.trim().isEmpty()) {
                    view.resVal(indicator, "Los campos no pueden estar vacíos");
                    return false;
                }
            }

            return true;
        }
}

