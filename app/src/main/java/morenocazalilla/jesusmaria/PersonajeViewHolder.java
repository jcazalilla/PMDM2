package morenocazalilla.jesusmaria;

import androidx.recyclerview.widget.RecyclerView;

import morenocazalilla.jesusmaria.databinding.PersonajeCardviewBinding;


public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;


    //Pasamos por parámetro el binding del layout item_cardview.xml
    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(Personaje personajeData) {

        binding.ivPhoto.setImageResource(personajeData.getPhotoID());
        binding.tvName.setText(personajeData.getName());

        // Asegura que se apliquen los cambios de inmediato
        binding.executePendingBindings();

    }

}