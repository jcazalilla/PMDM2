package morenocazalilla.jesusmaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import morenocazalilla.jesusmaria.databinding.PersonajeCardviewBinding;

/**
 * Clase adaptadora para RecyclerView
 */
public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    private final ArrayList<Personaje> listPersonajes;
    private final Context context;


    /**
     * Constructor del adaptador
     */
    public PersonajeRecyclerViewAdapter(ArrayList<Personaje> listPersonajes, Context context) {
        this.listPersonajes = listPersonajes;
        this.context = context;

    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new PersonajeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {

        Personaje currentPersonaje = this.listPersonajes.get(position);
        holder.bind(currentPersonaje);

        //manejar el evento click
        holder.itemView.setOnClickListener(view -> setOnItemClickListener(currentPersonaje, view));

    }

    @Override
    public int getItemCount() {
        return listPersonajes.size();
    }


    //setter del OnItemClickListener
    public void setOnItemClickListener(Personaje currentPersonaje, View view) {
        ((MainActivity) context).onItemClick(currentPersonaje, view);
    }


}
