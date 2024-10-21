package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    private val pokemonList = mutableListOf<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initPokemonList()
        setContent {
            PokemonTheme {
                LazyColumn(modifier = Modifier.statusBarsPadding()) {
                    items(pokemonList) { pokemon ->
                        PokemonBox(pokemon = pokemon, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }

    private fun initPokemonList() {
        assets.open("pokemons_data.csv").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                val row = line.split(",")
                val pokemonType = when (row[1]) {
                    "grass" -> Type.GRASS
                    "fire" -> Type.FIRE
                    "water" -> Type.WATER
                    else -> {
                        Type.PSYCHIC
                    }
                }
                val pokemon = Pokemon(
                    name = row[0],
                    type = pokemonType,
                    attack = row[2].toInt(),
                    defense = row[3].toInt(),
                    resources.getIdentifier(row[0].lowercase(), "drawable", packageName)
                )
                pokemonList.add(pokemon)
            }
        }
    }
}
