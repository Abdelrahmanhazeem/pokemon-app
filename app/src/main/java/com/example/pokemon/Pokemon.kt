package com.example.pokemon
import androidx.compose.ui.graphics.Color
import com.example.pokemon.ui.theme.FireBackground
import com.example.pokemon.ui.theme.FireBadge
import com.example.pokemon.ui.theme.GrassBackground
import com.example.pokemon.ui.theme.GrassBadge
import com.example.pokemon.ui.theme.PsychicBackground
import com.example.pokemon.ui.theme.PsychicBadge
import com.example.pokemon.ui.theme.WaterBackground
import com.example.pokemon.ui.theme.WaterBadge

data class Pokemon(
    val name: String,
    val type: Type,
    val attack: Int,
    val defense: Int,
    val image: Int
)

enum class Type(val displayName: String, val badgeColor: Color, val backgroundColor: Color) {

    GRASS("grass", GrassBadge, GrassBackground),
    FIRE("fire", FireBadge, FireBackground),
    WATER("water", WaterBadge, WaterBackground),
    PSYCHIC("psychic", PsychicBadge, PsychicBackground)
}