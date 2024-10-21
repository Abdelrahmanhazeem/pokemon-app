package com.example.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun PokemonBox(pokemon: Pokemon, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .padding(4.dp,4.dp)
            .fillMaxWidth()
            .background(color = pokemon.type.backgroundColor, shape = RoundedCornerShape(22.dp))
            .padding(18.dp)
    ) {
        ConstraintLayout(modifier.fillMaxWidth()) {
            val (pokeType, pokeName, pokeAttack, attackValue, pokeDefense, defenseValue, pokeImage) = createRefs()

            Text(
                text = pokemon.name,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(pokeName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = pokemon.type.displayName,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(6.dp)
                    .background(pokemon.type.badgeColor, RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .constrainAs(pokeType) {
                        start.linkTo(pokeName.start)
                        top.linkTo(pokeName.bottom)
                        bottom.linkTo(pokeDefense.bottom)
                    }
            )

            Text(
                text = stringResource(R.string.attack),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(6.dp)
                    .constrainAs(pokeAttack) {
                        start.linkTo(pokeType.end, 5.dp)
                        top.linkTo(pokeName.bottom, 10.dp)
                    }

            )

            Text(
                text = pokemon.attack.toString(),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(attackValue) {
                        start.linkTo(pokeAttack.end)
                        top.linkTo(pokeName.bottom, 10.dp)
                    }

            )

            Text(
                text = stringResource(R.string.defense),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(6.dp)
                    .constrainAs(pokeDefense) {
                        start.linkTo(pokeAttack.start)
                        top.linkTo(pokeAttack.bottom, 10.dp)
                    }

            )

            Text(
                text = pokemon.defense.toString(),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(defenseValue) {
                        start.linkTo(pokeDefense.end)
                        top.linkTo(pokeAttack.bottom, 10.dp)
                    }

            )

            Image(
                painter = painterResource(id = pokemon.image), contentDescription = stringResource(
                    R.string.pokemon_image
                ), modifier = Modifier
                    .background(color = Color.White.copy(.3f), CircleShape)
                    .size(110.dp)
                    .padding(12.dp)
                    .constrainAs(pokeImage) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PokemonBoxPreview() {
    PokemonBox(
        Pokemon(
            name = "Mega Meta-gross",
            type = Type.PSYCHIC,
            attack = 145,
            defense = 150,
            image = R.drawable.mega_metagross
        )
    )
}