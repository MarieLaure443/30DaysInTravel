package com.example.a30daysintravel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysintravel.data.DataSource
import com.example.a30daysintravel.model.Travel
import com.example.a30daysintravel.ui.theme._30DaysInTravelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysInTravelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val dataSource = DataSource()
                    TravelTheme30Days(dataSource = dataSource)
                }
            }
        }
    }
}

@Composable
fun TravelTheme30Days(modifier: Modifier = Modifier, dataSource: DataSource) {

}

@Composable
fun TravelTheme30DaysCard(travel: Travel, modifier: Modifier = Modifier) {
    Card {
        Column {
            Text(
                text = stringResource(id = travel.name),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center

            ) {
                Image(
                    painter = painterResource(id = travel.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = stringResource(id = travel.description))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TravelTheme30DaysPreview() {
    val travel = Travel(
        R.string.jour_1_title,
        R.string.jour_1_description,
        R.drawable.pexels_simon_rizzi_1809616
    )
    TravelTheme30DaysCard(travel = travel)
}