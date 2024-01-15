package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeMainActivity()
                }
            }
        }
    }
}

@Composable
fun ComposeMainActivity(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(1) }

    val artwork = when (counter) {
        1 -> Artwork(
            id = 1,
            image = painterResource(R.drawable.monna_lisa),
            contentDescription = stringResource(R.string.content_description_1),
            title = stringResource(R.string.title_1),
            artist = stringResource(R.string.artist_1),
            year = stringResource(R.string.year_1)
        )

        2 -> Artwork(
            id = 2,
            image = painterResource(R.drawable.cenacolo),
            contentDescription = stringResource(R.string.content_description_2),
            title = stringResource(R.string.title_2),
            artist = stringResource(R.string.artist_2),
            year = stringResource(R.string.year_2)
        )

        3 -> Artwork(
            id = 3,
            image = painterResource(R.drawable.primavera),
            contentDescription = stringResource(R.string.content_description_3),
            title = stringResource(R.string.title_3),
            artist = stringResource(R.string.artist_3),
            year = stringResource(R.string.year_3)
        )

        4 -> Artwork(
            id = 4,
            image = painterResource(R.drawable.le_moulin_de_la_galette),
            contentDescription = stringResource(R.string.content_description_4),
            title = stringResource(R.string.title_4),
            artist = stringResource(R.string.artist_4),
            year = stringResource(R.string.year_4)
        )

        5 -> Artwork(
            id = 5,
            image = painterResource(R.drawable.notte_stellata),
            contentDescription = stringResource(R.string.content_description_5),
            title = stringResource(R.string.title_5),
            artist = stringResource(R.string.artist_5),
            year = stringResource(R.string.year_5)
        )

        else -> throw Exception("Invalid counter value. Allowed values are from 1 to 5.")
    }

    Column {
        ArtworkPresentation(artwork = artwork)

        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.previous_button))
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.next_button))
            }
        }
    }

}


@Composable
fun ArtworkPresentation(artwork: Artwork, modifier: Modifier = Modifier) {
    Image(painter = artwork.image, contentDescription = artwork.contentDescription)
    Text(text = artwork.title)
    Text(text = stringResource(R.string.artist_and_year, artwork.artist, artwork.year))
}


@Preview(showBackground = true)
@Composable
fun ComposeMainActivityPreview() {
    ArtSpaceTheme {
        ComposeMainActivity()
    }
}