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

//    private RecyclerView recycleboy;
//    private boolean isLinear = false;
//    private Pokedex pokedex;
//    private ArrayList<Pokedex.Pokemon> pokemons;
//    private ArrayList<Pokedex.Pokemon> copy = new ArrayList<>();
//    private Pokedapter pokedapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//        recycleboy = (RecyclerView)findViewById(R.id.recycleboy);
//        if(isLinear){recycleboy.setLayoutManager(new LinearLayoutManager(this));}
//        else {recycleboy.setLayoutManager(new GridLayoutManager(this, 2));}
//
//        pokedex = new Pokedex();
//        pokemons = pokedex.getPokemon();
//        pokedapter = new Pokedapter(getApplicationContext(), pokemons);
//        recycleboy.setAdapter(pokedapter);
//
//        // copy pokemon into another list
//        for (int i = 0; i < pokemons.size(); i += 1) {
//            copy.add(i, pokemons.get(i));
//        }
//
//    }

    private RecyclerView recycleboy;
    private boolean isLinear = false;
    private ArrayList<Pokedex.Pokemon> pokemons;
    private ArrayList<Pokedex.Pokemon> lowHP;
    private ArrayList<Pokedex.Pokemon> medHP;
    private ArrayList<Pokedex.Pokemon> highHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recycleboy = (RecyclerView)findViewById(R.id.recycleboy);
        Pokedex pokedex = new Pokedex();
        pokemons = pokedex.getPokemon();
        lowHP = new ArrayList<>();
        medHP = new ArrayList<>();
        highHP = new ArrayList<>();
        updateRecyclerView(pokemons);

        // filter low HP pokemon
        for (int i = 0; i < pokemons.size(); i += 1) {
            String hpString = pokemons.get(i).hp;
            int hp = Integer.parseInt(hpString);
            if (hp < 50) {
                lowHP.add(pokemons.get(i));
            }
        }

        // filter med HP pokemon
        for (int i = 0; i < pokemons.size(); i += 1) {
            String hpString = pokemons.get(i).hp;
            int hp = Integer.parseInt(hpString);
            if (hp >= 50 && hp <= 100) {
                medHP.add(pokemons.get(i));
            }
        }

        // filter high HP pokemon
        for (int i = 0; i < pokemons.size(); i += 1) {
            String hpString = pokemons.get(i).hp;
            int hp = Integer.parseInt(hpString);
            if (hp > 100) {
                highHP.add(pokemons.get(i));
            }
        }
    }

    public void updateRecyclerView(ArrayList<Pokedex.Pokemon> p) {
        if(isLinear){recycleboy.setLayoutManager(new LinearLayoutManager(this));}
        else {recycleboy.setLayoutManager(new GridLayoutManager(this, 2));}
        Pokedapter pokedapter = new Pokedapter(getApplicationContext(), p, isLinear);
        recycleboy.setAdapter(pokedapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.filterLow) {
            if (item.isChecked()) {
                item.setChecked(false);

            }
        }



        int id = item.getItemId();
        if (id == R.id.filterLow) {
            if (item.isChecked()) {
                item.setChecked(false);
                for (int i = 0; i < copy.size(); i += 1) {
                    String hpString = copy.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp < 50) {
                        copy.remove(i);
                    }
                }
            } else {
                item.setChecked(true);
                for (int i = 0; i < pokemons.size(); i += 1) {
                    String hpString = pokemons.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp < 50) {
                        if (!(copy.contains(pokemons.get(i)))) {
                            copy.add(i, pokemons.get(i));
                        }
                    }
                }
            }
            pokedapter.setList(copy);
            pokedapter.notifyDataSetChanged();
        } else if (id == R.id.filterMed) {
            if (item.isChecked()) {
                item.setChecked(false);
                for (int i = 0; i < copy.size(); i += 1) {
                    String hpString = copy.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp >= 50 && hp <= 100) {
                        copy.remove(i);
                    }
                }
            } else {
                item.setChecked(true);
                for (int i = 0; i < pokemons.size(); i += 1) {
                    String hpString = pokemons.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp >= 50 && hp <= 100) {
                        if (!(copy.contains(pokemons.get(i)))) {
                            copy.add(i, pokemons.get(i));
                        }
                    }
                }
            }
            pokedapter.setList(copy);
            pokedapter.notifyDataSetChanged();
        } else {
            if (item.isChecked()) {
                item.setChecked(false);
                for (int i = 0; i < copy.size(); i += 1) {
                    String hpString = copy.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp > 100) {
                        copy.remove(i);
                    }
                }
            } else {
                item.setChecked(true);
                for (int i = 0; i < pokemons.size(); i += 1) {
                    String hpString = pokemons.get(i).hp;
                    int hp = Integer.parseInt(hpString);
                    if (hp > 100) {
                        if (!(copy.contains(pokemons.get(i)))) {
                            copy.add(i, pokemons.get(i));
                        }
                    }
                }
            }
            pokedapter.setList(copy);
            pokedapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
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

        menu.findItem(R.id.filterLow).setChecked(true);
        menu.findItem(R.id.filterMed).setChecked(true);
        menu.findItem(R.id.filterHigh).setChecked(true);

        return true;
    }

    public void switchLayout(MenuItem item){
        if(!isLinear){
            recycleboy.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recycleboy.setLayoutManager(new GridLayoutManager(this, 2));
        }
        isLinear = !isLinear;
    }
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
