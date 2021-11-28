package com.grupoOnce.vista;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;

import androidx.annotation.IntDef;
import androidx.annotation.WorkerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.content.ContextCompat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.Manifest;

public class Camara {


    public class MainActivity extends AppCompatActivity {
        ImageView selectedImage;
        Button cameraBt;
        public static final int CAMERA_PERMISSION_CODE = 101;
        public static final int CAMERA_REQUEST_CODE = 102;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getSupportActionBar().hide();
            passView();

            selectedImage = findViewById(R.id.tomarFoto);
            cameraBt = findViewById(R.id.button5);

            cameraBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(MainActivity,"Se activará la cámara", Toast.LENGTH_SHORT).show();
                    askCameraPermission();
                }
            });


        }

        private void askCameraPermission() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            } else {
                openCamera();
            }

        }


        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if (requestCode == CAMERA_PERMISSION_CODE) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Se requiere acceder a la cámara para continuar", Toast.LENGTH_LONG).show();
                }
            }
        }


        private void openCamera() {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //startActivityForResult(camera, CAMERA_REQUEST_CODE);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST_CODE) {
                Bitmap image = (Bitmap) data.getExtras().get("data");
                selectedImage.setImageBitmap(image);
            }
        }

    }

};
