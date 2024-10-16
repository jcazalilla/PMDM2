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
    private ActivityMainBinding binding;
    private MiAdaptador miAdaptador;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //llamamos a la pantalla de detalle del personaje
       /*recyclerView.findViewById(R.id.detalle_personaje);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(miAdaptador);*/

        inicializarDatos();
        iniciaAdapter();


    }

    private void abrirPantallaDetalle(int i, View view) {
        Toast.makeText(this, "Se ha seleccionado " + listaPersonajes.get(i), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetallePersonaje.class);
        startActivity(intent);
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

        Personaje MarioBross = new Personaje("Mario Bross",
                "Mario es muy positivo y siempre está alegre.", R.drawable.mario);
        listaPersonajes.add(MarioBross);
        Personaje Peach = new Personaje("Peach",
                "Siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices.", R.drawable.peach);
        listaPersonajes.add(Peach);
        Personaje Luigi = new Personaje("Luigi",
                "Un poco de nervioso, especialmente si hay fantasmas por ahí. Es hermano de Mario.", R.drawable.luigi);
        listaPersonajes.add(Luigi);
        Personaje Toad = new Personaje("Toad",
                "Tiene manchas rojas en la cabeza, es muy alegre y leal.", R.drawable.toad);
        listaPersonajes.add(Toad);
    }

    //método que se va a ejecutar al pulsar sobre el recyclerView
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,
                "Personjae seleccionado: "+listaPersonajes.get(position).name, Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(MainActivity.this, DetallePersonaje.class);
        startActivity(intent);
    }
}