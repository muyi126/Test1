/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row



import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Divider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

import com.example.androiddevchallenge.ui.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyTheme() {
                Log.i("XXX", "MyTheme")
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomePage(navController = navController)
                    }
                    composable("des_screen/{des}") { backStackEntry ->
                        backStackEntry.arguments?.getString("des")?.let {
                            Log.i("XXX", "DesPage${it}")
                            DesPage(
                                navController = navController,
                                it.toInt()
                            )
                        }
                    }

                }
            }
        }
    }


}

@Composable
fun ComposeNavigation() {


}

@Composable
fun DesPage(navController: NavController, des: Int) {
    val loadData = loadData()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        loadData.get(des)?.imageUrl?.let {
            CoilImage(
                data = it,
                contentDescription = "Puppy img",
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.small)
                    .padding(5.dp)
            )
        }
        Text(
            text = "${loadData.get(des)?.puppyName}",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(24.dp)
                .clickable(onClick = {
                    // this will navigate to second screen
                    navController.navigate("home")
                })
        )
        Text(
            text = "${loadData.get(des)?.puppyDetail}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(24.dp)
                .clickable(onClick = {
                    // this will navigate to second screen
                    navController.navigate("home")
                })
        )
    }
}


fun loadData(): Array<Puppy?> {
    var puppys: Array<Puppy?> = emptyArray()
    puppys = puppys.plus(
        Puppy(
            0,
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4237322682,366773528&fm=11&gp=0.jpg",
            "Realistic Golden Retriever Puppy Hunde",
            "With 30 years of pet making experience, each one comes realistic\nThe average production time is usually 5-15 days, please be patient\nCan provide customized your favorite pet\nRealistic Golden Retriever Puppy Hunde",
            27.98f
        )
    )
    puppys = puppys.plus(
        Puppy(
            1,
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1243712943,297254073&fm=26&gp=0.jpg",
            "Realistic cute baby Portrait pet handmade Husky Dog Puppy",
            "With 30 years of pet making experience, each one comes realistic\nThe average production time is usually 5-15 days, please be patient\nCan provide customized your favorite pet\nRealistic Golden Retriever Puppy Hunde",
            19.99f
        )
    )

    puppys = puppys.plus(
        Puppy(
            2,
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1408037284,1604124368&fm=26&gp=0.jpg",
            "Realistic Puppy Havanese",
            "With 30 years of pet making experience, each one comes realistic\nThe average production time is usually 5-15 days, please be patient\nCan provide customized your favorite pet\nRealistic Golden Retriever Puppy Hunde",
            19.99f
        )
    )

    puppys = puppys.plus(
        Puppy(
            3,
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3023697944,3920609074&fm=26&gp=0.jpg",
            "Realistic toy puppy dog",
            "With 30 years of pet making experience, each one comes realistic\nThe average production time is usually 5-15 days, please be patient\nCan provide customized your favorite pet\nRealistic Golden Retriever Puppy Hunde",
            19.99f
        )
    )

    puppys = puppys.plus(
        Puppy(
            4,
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1166008904,72002397&fm=26&gp=0.jpg",
            "Realistic Pomeranian Simulation Toy Dog Puppy",
            "With 30 years of pet making experience, each one comes realistic\nThe average production time is usually 5-15 days, please be patient\nCan provide customized your favorite pet\nRealistic Golden Retriever Puppy Hunde",
            21.99f
        )
    )


    return puppys
}


// Start building your app here!
@Composable
fun HomePage(navController: NavController) {
    Log.i("XXX", "MyApp")
    Surface(color = MaterialTheme.colors.background) {
        ImageList(navController)
    }
}


@Composable
fun ImageList(navController: NavController) {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    val datas = loadData()
    LazyColumn(state = scrollState) {
        items(100) {
            var i = it % 5
            datas.get(i)?.let { it1 -> ImageListItem(it1, navController) }
        }
    }
}


@Composable
fun ImageListItem(it: Puppy, navController: NavController) {

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = { navController.navigate("des_screen/${it.id}") })
        ) {
            CoilImage(
                data = it.imageUrl,
                contentDescription = "Puppy img",
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.small)
                    .padding(5.dp)
            )

            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("[${it.puppyName}]", style = MaterialTheme.typography.subtitle1)
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "[Des:${it.puppyDetail}]",
                        style = MaterialTheme.typography.body2,
                        maxLines = 2
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }

        }
        PostListDivider()
    }

}

@Composable
private fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}


@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomePage(rememberNavController())
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomePage(rememberNavController())
    }
}
