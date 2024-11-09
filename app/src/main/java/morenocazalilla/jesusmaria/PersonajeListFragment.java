package morenocazalilla.jesusmaria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import morenocazalilla.jesusmaria.databinding.PersonajeListFragmentBinding;

public class PersonajeListFragment extends Fragment {

    private PersonajeListFragmentBinding binding;
    private ArrayList<Personaje> listPersonajes;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflar el layout usando binding
        binding = PersonajeListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inicializa la lista de personajes
        inicializarDatos();

        //Configura el RecyclerView
        PersonajeRecyclerViewAdapter adaptador = new PersonajeRecyclerViewAdapter(listPersonajes, getActivity());
        binding.personajeRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajeRecyclerview.setAdapter(adaptador);

    }

    public void onStart() {
        super.onStart();
        //cambia el título de la ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.nombre_del_personaje);
        }
    }

    private void inicializarDatos() {

        //creamos la lista de personajes
        listPersonajes = new ArrayList<Personaje>();

        Personaje MarioBross = new Personaje("Mario",
                "Mario es muy positivo y siempre está alegre.",
                "Increíble capacidad para saltar, destreza en el combate", R.drawable.mario);
        listPersonajes.add(MarioBross);
        //*
        Personaje Peach = new Personaje("Peach",
                "Siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices.",
                "Puede flotar en el aire, lo que le da una buena ventaja al ser arrojada y poder regresar.", R.drawable.peach);
        listPersonajes.add(Peach);
        //*
        Personaje Luigi = new Personaje("Luigi",
                "Un poco de nervioso, especialmente si hay fantasmas por ahí. Es el hermano menor de Mario.",
                "Salta más alto pero corre más lento.", R.drawable.luigi);
        listPersonajes.add(Luigi);
        //*
        Personaje Toad = new Personaje("Toad",
                "Tiene manchas en la cabeza, es muy alegre y leal.",
                "Es uno de los protectores de la Princesa Peach.", R.drawable.toad);
        listPersonajes.add(Toad);
    }


}
