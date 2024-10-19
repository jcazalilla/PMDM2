package morenocazalilla.jesusmaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetallePersonaje extends AppCompatActivity {

    Button btnVolver;
    ImageView imageView;
    TextView textViewTitulo, textViewDescripcion, textViewHabilidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_personaje);

        btnVolver = findViewById(R.id.btn_volver);
        imageView = findViewById(R.id.iv_personaje);
        textViewTitulo = findViewById(R.id.tv_personaje);
        textViewHabilidades = findViewById(R.id.tv_habilidades);
        textViewDescripcion = findViewById(R.id.tv_personaje_descripcion);

        presentarDatosEnPantalla();


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallePersonaje.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void presentarDatosEnPantalla() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        textViewTitulo.setText(bundle.getString("name"));
        textViewDescripcion.setText("** Descripción:\n "+bundle.getString("description"));
        textViewHabilidades.setText("** Habilidades: \n"+bundle.getString("habilidades"));

        int id = bundle.getInt("id");
        switch (id) {
            case 0:
                imageView.setImageResource(R.drawable.mario);

                break;
            case 1:
                imageView.setImageResource(R.drawable.peach);
                break;
            case 2:
                imageView.setImageResource(R.drawable.luigi);
                break;
            case 3:
                imageView.setImageResource(R.drawable.toad);
                break;


        }
    }


}