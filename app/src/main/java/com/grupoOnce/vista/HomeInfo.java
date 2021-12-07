package com.grupoOnce.vista;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.grupoOnce.vista.databinding.ActivityHomeInfoBinding;

public class HomeInfo extends AppCompatActivity {

    private ActivityHomeInfoBinding binding;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        redirectionToLogin(this);
        redirectionToRegister(this);


    }


    public void redirectionToRegister(Activity activity) {

        binding.txtRegistrarse.setOnClickListener(v -> {
            Intent newView = new Intent(activity, Registro.class);
            startActivity(newView);
        });

    }

    public void redirectionToLogin(Activity activity) {

        binding.txtIniciarSesion.setOnClickListener(v -> {
            Intent newView = new Intent(activity, login.class);
            startActivity(newView);
        });
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_superior, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menu_invitar_amigos){

            Intent newView = new Intent(this, InvitarAmigos.class);
            startActivity(newView);
            finish();
            //Toast.makeText(this, "Ha elegido Invitar Amigos", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_salir){
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeInfo.this);
            builder.setMessage("¿Realemente desea Salir?");
            builder.setCancelable(true);

            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this, "Ha elegido la opción Salir", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}



