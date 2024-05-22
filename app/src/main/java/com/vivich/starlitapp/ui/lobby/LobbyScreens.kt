package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LobbyScreen(
    openDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            LobbyTopNav(openDrawer)
        }
    ){innerPadding->
        val screenModifier = Modifier.padding(innerPadding)

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .scrollable(scrollState, Orientation.Vertical)
        ){
            Text(text = "Screen Content (Lobby)")

            CardRow()
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardRow(){

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show bottom sheet") },
//                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
//                onClick = {
//                    showBottomSheet = true
//                }
//            )
//        }
    ) { contentPadding ->
        // Screen content
        LazyRow {
            items(3){
                ElevatedCard(
                    modifier = Modifier
                        .clickable {
                            showBottomSheet = true
                        }
                        .size(300.dp, 500.dp)
                        .padding(start = 20.dp, top = 10.dp)
                ){
                    CardDisplay()
                }
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(0.95f),
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                PostDisplay()
//                Button(onClick = {
//                    scope.launch { sheetState.hide() }.invokeOnCompletion {
//                        if (!sheetState.isVisible) {
//                            showBottomSheet = false
//                        }
//                    }
//                }) {
//                    Text("Hide bottom sheet")
//
//                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDisplay(
){
    Box(contentAlignment = Alignment.BottomEnd){
        Image(
            painter = rememberAsyncImagePainter(model = "https://image.geo.de/31549038/t/3T/v3/w1440/r1.5/-/sokrates-statue---adobestock-422840755.jpg"),
            contentDescription = "profile image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ){
            Text(
                text = "Placeholder text",
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .weight(3f)
                    .align(Alignment.CenterVertically),
            )
            IconToggleButton(
                modifier = Modifier.weight(1f),
                checked = false,
                onCheckedChange = {
                }
            ) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Fave")
            }
        }
    }

}


@Composable
fun PostDisplay(){
    Card(
        modifier = Modifier.fillMaxSize().padding(0.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ){
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = rememberAsyncImagePainter(model="https://image.geo.de/31549038/t/3T/v3/w1440/r1.5/-/sokrates-statue---adobestock-422840755.jpg"),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
            ){
                Text(text = "Aristotle", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(10.dp))
                val randomText = "We may now return to the Good which is the object of our search, and try to find out what exactly it can be. For good appears to be one thing in one pursuit or art and another in another: it is different in medicine from what it is in strategy, and so on with the rest of the arts. What definition of the Good then will hold true in all the arts? Perhaps we may define it as that for the sake of which everything else is done. This applies to something different in each different art—to health in the case of medicine, to victory in that of strategy, to a house in architecture, and to something else in each of the other arts; but in every pursuit or undertaking it describes the end of that pursuit or undertaking, since in all of them it is for the sake of the end that everything else is done."
                Text(text = randomText, color = Color.White.copy(alpha = 0.5f), fontSize = 22.sp, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape),
                        painter = rememberAsyncImagePainter(model="https://image.geo.de/31549038/t/3T/v3/w1440/r1.5/-/sokrates-statue---adobestock-422840755.jpg"),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.height( 10.dp))
                    Text(text = "Author", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}