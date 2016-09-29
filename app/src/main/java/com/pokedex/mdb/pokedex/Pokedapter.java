package com.pokedex.mdb.pokedex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aayush on 9/28/2016.
 */

public class Pokedapter extends RecyclerView.Adapter<Pokedapter.CustomViewHolder> {

    private Context context;
    private ArrayList<Pokedex.Pokemon> pokemons;

    public Pokedapter(Context context, ArrayList<Pokedex.Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    /* In simplified terms, a ViewHolder is an object that holds the pointers to the views in each
    each row. What does that mean? Every row has a TextView, ImageView, and CheckBox. Each row has
    a ViewHolder, and that ViewHolder holder these 3 views in it (hence "view holder").
    This function returns a single ViewHolder; it is called once for every row.
    */
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        This "inflates" the views, using the layout R.layout.row_view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new CustomViewHolder(view);
    }

    /* This function takes the previously made ViewHolder and uses it to actually display the
    data on the screen. Remember how the holder contains (pointers to) the 3 views? By doing, for
    example, "holder.imageView" we are accessing the imageView for that row and setting the
    ImageResource to be the corresponding image for that subject.
     */
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Pokedex.Pokemon pokemon = pokemons.get(position);

        holder.pokemonNameTextView.setText(pokemon.name);
        //TODO holder.imageView.setImageResource(schoolSubject.imageId);
        holder.pokemonNumberTextView.setText("#" + (String)pokemon.number);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonNameTextView;
        ImageView imageView;
        TextView pokemonNumberTextView;

        public CustomViewHolder (View view) {
            super(view);
            this.pokemonNameTextView = (TextView) view.findViewById(R.id.nameTextView);
            //TODO this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.pokemonNumberTextView = (TextView) view.findViewById(R.id.numberTextView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Get adapter position is getting the number of the row that was clicked,
                    starting at 0
                    */
                    Pokedex.Pokemon pokemon = pokemons.get(getAdapterPosition());
                    Toast.makeText(context, pokemon.name, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
