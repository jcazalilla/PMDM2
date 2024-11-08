package morenocazalilla.jesusmaria;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import morenocazalilla.jesusmaria.databinding.ItemCardviewBinding;


public class ViewHolder extends RecyclerView.ViewHolder {

    private final ItemCardviewBinding binding;


    //Pasamos por parámetro el binding del layout item_cardview.xml
    public ViewHolder(ItemCardviewBinding binding) {
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