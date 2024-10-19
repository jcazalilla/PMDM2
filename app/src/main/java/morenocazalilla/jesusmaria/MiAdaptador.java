package morenocazalilla.jesusmaria;

import android.app.DatePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Clase adaptadora para RecyclerView
 */
public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private ArrayList<Personaje> listPersonajes;
    //objeto de tipo interface de nuestro paquete
    // no de la clase android.widget
    OnItemClickListener miListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * Constructor del adaptador
     */
    public MiAdaptador(ArrayList<Personaje> listPersonajes) {
        this.listPersonajes = listPersonajes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.asignarPersonajes(listPersonajes.get(position));
    }

    @Override
    public int getItemCount() {
        return listPersonajes.size();
    }


    //setter del OnItemClickListener
    public void setOnItemClickListener(OnItemClickListener onItemClick) {
        this.miListener = onItemClick;
    }

    /**
     * clase ViewHolder
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
        //los datos que tenemos en el layout item.xml
        //que mostraremos en el RecyclerView
        ImageView photo;
        TextView name;
        TextView description;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv);
            name = itemView.findViewById(R.id.tv_name);
            //description = itemView.findViewById(R.id.tv_description);
            photo = itemView.findViewById(R.id.iv_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //código que queremos hacer cuando se pulse sobre un elemento
                    //del recyclerView
                    miListener.onItemClick(view, getAdapterPosition());
                }
            });
        }


        public void asignarPersonajes(Personaje personaje) {

            photo.setImageResource(personaje.getPhotoID());
            name.setText(personaje.getName());
            //description.setText(personaje.getDescription());


        }
    }
}
