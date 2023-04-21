//import com.example.course.R
package com.example.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course.ui.theme.CourseTheme
import model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                CourseTheme() {


                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                    ) {
                        TopicGrid()
               }
            }
        }
    }
}


@Composable
fun TopicCard (topic: Topic) {
    Card() {//elevation = 3.dp
        Row() {
            Image(
                painter = painterResource(id = topic.linkToRes),
                contentDescription = topic.nameOfImage.toString(), //Картинка слева
                modifier = Modifier.size(68.dp)
            )
            Column() { //Колонка для тайтла и иконки с хуй пойми цифрой
                Text(
                    text = stringResource(id = topic.nameOfImage), //Тайтл
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
                )
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "grain logo", //xml - дротч
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp, bottom = 8.dp)
                    )
                    Text(
                        text = topic.numIdkWhat.toString(),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) //хуй-пойми цифра
                }
            }
        }
    }
}
@Composable
fun TopicGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(DataSource.topics) {topic ->
            TopicCard(topic)
        }
    }
}

