package morenocazalilla.jesusmaria;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import morenocazalilla.jesusmaria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // viewBinding, inflamos el Main Layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // Configura NavController
        navController = Navigation.findNavController(this, R.id.host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    // método para manejar click sobre RecyclerView
    public void onItemClick(Personaje personaje, View view) {

        Bundle bundle = new Bundle();

        bundle.putString("name", personaje.getName());
        bundle.putInt("image", personaje.getPhotoID());
        bundle.putString("description", personaje.getDescription());
        bundle.putString("ability", personaje.getAbility());
        

        // Navega al Fragment con el bundle
        Navigation.findNavController(view).navigate(R.id.personajeListFragment, bundle);
    }

    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}