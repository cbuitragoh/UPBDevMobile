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
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        //passView();
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



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.item1){

            Toast.makeText(this, "Ha elegido la opción 1 del menú", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item2){

            Toast.makeText(this, "Ha elegido la opcion 2", Toast.LENGTH_SHORT).show();

        }else if(id == R.id.item3){

        Toast.makeText(this, "Ha elegido la opcion 3", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.navigation_salir){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("¿Salir de la aplicación?");
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
