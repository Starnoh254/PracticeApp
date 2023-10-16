package com.starnoh.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starnoh.practice.model.Topic
import com.starnoh.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun CourseApp(){
    ListOfCourses(listOfTopics = DataSource.topics)
}

@Composable
fun  CourseTopicCard(modifier: Modifier = Modifier , topic: Topic ){
    Card(modifier = modifier){
        Row {
            Image(
                painter = painterResource(id = topic.drawable),
                contentDescription = stringResource(id = topic.string)
            )
            Column (Modifier.padding(bottom = 4.dp , start = 4.dp , end = 8.dp)){
                Text(text = stringResource(id = topic.string), fontSize = 10.sp)
                Row {
                    Image(painter = painterResource(id = R.drawable.ic_grain),
                        modifier = modifier
                            .size(width = 68.dp, height = 68.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop,
                        contentDescription = null)

                    Text(text = topic.imageNo.toString(), fontSize = 10.sp)
                }
            }
        }

    }

}

@Composable
fun ListOfCourses(modifier: Modifier = Modifier , listOfTopics : List<Topic>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ){
        items(listOfTopics) {
            CourseTopicCard(modifier = Modifier.padding(2.dp),topic = it)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        CourseApp()
    }
}