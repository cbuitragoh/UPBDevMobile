package com.grupoOnce.vista;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.grupoOnce.vista.databinding.ActivityDetalleBinding;
import com.grupoOnce.vista.databinding.FragmentHomeBinding;
import com.grupoOnce.vista.ui.home.HomeFragment;

import java.util.Objects;

import Controllers.ControladorDetalle;
import Interfaces.DetalleInterfaz;
import Models.ConexionSQLHelper;
import Models.FormularioPublicacionDTO;
import Models.PublicacionesDTO;
import db.Product;


public class Detalle extends AppCompatActivity implements DetalleInterfaz.View {

    private ActivityDetalleBinding binding;
    private final ControladorDetalle Controlador = new ControladorDetalle(this);
    private static ConexionSQLHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar()).hide();
        dbHelper = new ConexionSQLHelper(this);

        mostrarPublicaciones();
        Eliminar();

    }

    @Override
    public void mostrarPublicaciones() {
        binding.editNombreAlimento.setText(getIntent().getExtras().getString("nombre"));
        binding.textBoxFv.setText(getIntent().getExtras().getString("fechaVencimiento"));
        binding.textBoxProduct.setText(getIntent().getExtras().getString("tipo"));
        binding.textBoxDescripcion.setText(getIntent().getExtras().getString("comentario"));
        binding.editFotoAlimento.setImageBitmap(Product.convertByteArrayToBitmap(getIntent().getExtras().getByteArray("foto")));
    }

    @Override
    public void respuestaEliminacion(Boolean respuesta) {
        String message = respuesta ? "Producto Eliminado" : "Producto no se pudo eliminar";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    /*----------------Botón lo Quiero--------------------------*/

    public void Eliminar() {
        binding.btnLoQuiero.setOnClickListener(v -> {
            PublicacionesDTO publicacion = getValues();

            boolean productDeleted  = Controlador.eliminarPublicacion(publicacion, dbHelper);
                /*Crear redireccion a la vista de productos*/
                if (productDeleted) {
                    Intent intent = new Intent(this, NavigationMenu.class);
                    startActivity(intent);
                    finish();
                }

        });
    }

    private PublicacionesDTO getValues(){
        PublicacionesDTO publicacion = new PublicacionesDTO();
        publicacion.setNombre(getIntent().getExtras().getString("nombre"));
        return publicacion;
    }

}