package com.grupoOnce.vista;

import android.content.DialogInterface;
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
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.grupoOnce.vista.databinding.ActivityNavigationMenuBinding;

public class NavigationMenu extends AppCompatActivity {

    Menu menu;
    private ActivityNavigationMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_navigation_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(NavigationMenu.this);
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