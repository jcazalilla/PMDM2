package morenocazalilla.jesusmaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final int PANTALLA_DESCRIPCION = 10;
    ArrayList<Personaje> listaPersonajes;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //llamamos a la pantalla de detalle del personaj
        recyclerView.findViewById(R.id.detalle_personaje);

        inicializarDatos();
        iniciaAdapter();

        recyclerView.setOnClickListener(this);


    }

    private void iniciaAdapter() {
        //pasamos la lista al adaptador
        MiAdaptador adaptador = new MiAdaptador(listaPersonajes);
        //pasamos como referencia el adaptador al Recycler
        recyclerView.setAdapter(adaptador);

    }

    private void inicializarDatos() {

        //creamos la lista de personajes
        listaPersonajes = new ArrayList<Personaje>();

        Personaje MarioBross = new Personaje("Mario Bross",
                "Mario es muy positivo y siempre está alegre.", R.mipmap.mario);
        listaPersonajes.add(MarioBross);
        Personaje Peach = new Personaje("Peach",
                "Siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices.", R.mipmap.peach);
        listaPersonajes.add(Peach);
        Personaje Luigi = new Personaje("Luigi",
                "Un poco de nervioso, especialmente si hay fantasmas por ahí. Es hermano de Mario.", R.mipmap.luigi);
        listaPersonajes.add(Luigi);
        Personaje Toad = new Personaje("Toad",
                "Tiene manchas rojas en la cabeza, es muy alegre y leal.", R.mipmap.toad);
        listaPersonajes.add(Toad);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DetallePersonaje.class);
        startActivity(intent);
    }
}