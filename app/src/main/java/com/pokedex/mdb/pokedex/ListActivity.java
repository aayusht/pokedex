package com.pokedex.mdb.pokedex;

/**
 * Created by Aayush on 9/28/2016.
 */

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;

        import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recycleboy = (RecyclerView)findViewById(R.id.recycleboy);
        recycleboy.setLayoutManager(new LinearLayoutManager(this));

        Pokedex pokedex = new Pokedex();
        ArrayList<Pokedex.Pokemon> pokemons = pokedex.getPokemon();
        Pokedapter pokedapter = new Pokedapter(getApplicationContext(), pokemons);
        recycleboy.setAdapter(pokedapter);
    }


}
