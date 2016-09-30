package com.pokedex.mdb.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class PokemonActivity extends AppCompatActivity {

    private String name;
    private String url;
    private TextView number;
    private TextView attack;
    private TextView defense;
    private TextView hp;
    private TextView species;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = (TextView)findViewById(R.id.number);
        attack = (TextView)findViewById(R.id.attack);
        defense = (TextView)findViewById(R.id.defense);
        hp = (TextView)findViewById(R.id.hp);
        species = (TextView)findViewById(R.id.species);
        img = (ImageView)findViewById(R.id.imageView);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        setTitle(name);
        Glide.with(getApplicationContext()).load(url).thumbnail(0.5f).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
        number.setText("Number: #" + b.get("number"));
        attack.setText("Attack: " + ("attack"));
        defense.setText("Defense: " + b.get("defense"));
        hp.setText("HP: " + b.get("hp"));
        species.setText("Species: " + b.get("species"));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with online search", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
