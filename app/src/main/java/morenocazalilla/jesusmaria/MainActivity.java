package morenocazalilla.jesusmaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import morenocazalilla.jesusmaria.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements MiAdaptador.OnItemClickListener {

    private ArrayList<Personaje> listaPersonajes;
    private RecyclerView recyclerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        inicializarDatos();
        iniciaAdapter();


    }

    private void iniciaAdapter() {
        //pasamos la lista al adaptador
        MiAdaptador adaptador = new MiAdaptador(listaPersonajes);
        adaptador.setOnItemClickListener(this);
        //pasamos como referencia el adaptador al Recycler
        recyclerView.setAdapter(adaptador);

    }

    private void inicializarDatos() {

        //creamos la lista de personajes
        listaPersonajes = new ArrayList<>();

        Personaje MarioBross = new Personaje("Mario",
                "Mario es muy positivo y siempre está alegre.", R.drawable.mario,
                "Increíble capacidad para saltar, destreza en el combate");
        listaPersonajes.add(MarioBross);
        //*
        Personaje Peach = new Personaje("Peach",
                "Siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices.", R.drawable.peach,
                "Puede flotar en el aire, lo que le da una buena ventaja al ser arrojada y poder regresar.");
        listaPersonajes.add(Peach);
        //*
        Personaje Luigi = new Personaje("Luigi",
                "Un poco de nervioso, especialmente si hay fantasmas por ahí. Es el hermano menor de Mario.", R.drawable.luigi,
                "Salta más alto pero corre más lento.");
        listaPersonajes.add(Luigi);
        //*
        Personaje Toad = new Personaje("Toad",
                "Tiene manchas en la cabeza, es muy alegre y leal.", R.drawable.toad,
                "Es uno de los protectores de la Princesa Peach.");
        listaPersonajes.add(Toad);
    }

    //método que se va a ejecutar al pulsar sobre el recyclerView
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,
                "Detalles cargados para " + listaPersonajes.get(position).getName(), Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putString("name", listaPersonajes.get(position).getName());
        bundle.putString("description", listaPersonajes.get(position).getDescription());
        bundle.putString("habilidades", listaPersonajes.get(position).getHabilidades());
        bundle.putInt("id", position);

        Intent intent = new Intent(MainActivity.this, DetallePersonaje.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}