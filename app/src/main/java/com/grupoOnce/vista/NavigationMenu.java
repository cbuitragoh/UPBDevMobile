package com.grupoOnce.vista;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.grupoOnce.vista.databinding.ActivityNavigationMenuBinding;
import com.grupoOnce.vista.ui.home.HomeFragment;

import java.util.Objects;

public class NavigationMenu extends AppCompatActivity {

    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_navigation_menu);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(NavigationMenu.this);
            builder.setMessage("¿Realemte desea salir?");
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