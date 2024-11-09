package morenocazalilla.jesusmaria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import morenocazalilla.jesusmaria.databinding.PersonajeDetailFragmentBinding;
import morenocazalilla.jesusmaria.databinding.PersonajeListFragmentBinding;

public class PersonajeDetailFragment extends Fragment {

    private PersonajeDetailFragmentBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = PersonajeDetailFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //obetener datos del argumento que inicia este fragmento
        if (getArguments() != null) {

            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String ability = getArguments().getString("ability");
            int image = getArguments().getInt("image");

            //asignamos los datos a los componentes
            binding.tvHabilidades.setText(ability);
            binding.ivPersonaje.setImageResource(image);
            binding.tvName.setText(name);
            binding.tvPersonajeDescripcion.setText(description);




        }
    }

    public void onStart() {
        super.onStart();
        //cambia título de la ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalles_del_personaje);
        }
    }

}