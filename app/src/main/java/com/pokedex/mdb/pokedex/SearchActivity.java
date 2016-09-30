package com.pokedex.mdb.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    EditText search;
    Pokedex dex = new Pokedex();
    ArrayList<Pokedex.Pokemon> pokemon = dex.getPokemon();
    ArrayList<Pokedex.Pokemon> copy = new ArrayList<>();
    Pokedapter adapter = new Pokedapter(getApplicationContext(), pokemon);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // copy pokemon into another list
                for (int i = 0; i < pokemon.size(); i += 1) {
                    copy.add(i, pokemon.get(i));
                }

                // start search function
                for (int i = 0; i < copy.size(); i += 1) {
                    if (!(copy.get(i).name.substring(0, s.length()).equals(s))) {
                        copy.remove(i);
                    }
                }

                // reset the list in adapter and notify change
                adapter.setList(copy);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
