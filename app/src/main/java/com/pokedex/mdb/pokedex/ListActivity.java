package com.pokedex.mdb.pokedex;

/**
 * Created by Aayush on 9/28/2016.
 */

        import android.app.SearchManager;
        import android.content.Context;
        import android.support.v4.view.MenuItemCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.SearchView;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.Toast;

        import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recycleboy;
    private boolean isLinear = false;
    private ArrayList<Pokedex.Pokemon> pokemons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recycleboy = (RecyclerView)findViewById(R.id.recycleboy);
        Pokedex pokedex = new Pokedex();
        pokemons = pokedex.getPokemon();
        updateRecyclerView();
    }

    public void updateRecyclerView() {
        if(isLinear){recycleboy.setLayoutManager(new LinearLayoutManager(this));}
        else {recycleboy.setLayoutManager(new GridLayoutManager(this, 2));}
        Pokedapter pokedapter = new Pokedapter(getApplicationContext(), pokemons, isLinear);
        recycleboy.setAdapter(pokedapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default

        return true;
    }

    public void switchLayout(MenuItem item){
        isLinear = !isLinear;
        updateRecyclerView();
    }

    public boolean isLinear() {return isLinear;}
/*
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this)

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        return false;
    }*/
}
