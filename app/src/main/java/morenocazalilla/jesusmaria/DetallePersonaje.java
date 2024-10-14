package morenocazalilla.jesusmaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class DetallePersonaje extends AppCompatActivity {
    Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);


        btnVolver.findViewById(R.id.btn_volver);



    }
}