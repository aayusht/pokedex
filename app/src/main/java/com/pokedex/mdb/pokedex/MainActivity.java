package com.pokedex.mdb.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<com.demo.mdb.pokedex.Pokedex.Pokemon> pokemon = com.demo.mdb.pokedex.Pokedex.getPokemon();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
