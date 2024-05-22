package com.vivich.starlitapp.ui.lobby

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.vivich.starlitapp.model.post.FakeCard
import com.vivich.starlitapp.model.post.bigFakeCardData
import com.vivich.starlitapp.model.post.mediumFakeCardData

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
                .fillMaxSize()
                .verticalScroll(scrollState) // Use verticalScroll instead of scrollable
        ){
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                text = "Latest Updated",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )
            CardRow(DpSize(300.dp, 500.dp), bigFakeCardData)
//            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                text = "Recommended",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )
            CardRow(DpSize(150.dp, 150.dp), mediumFakeCardData)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardRow(
    cardSize: DpSize,
    fakeCards: List<FakeCard>
){
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    val index = remember { mutableStateOf(0)}
    LazyRow {
        items(fakeCards.size){
            ElevatedCard(
                modifier = Modifier
                    .clickable {
                        showBottomSheet = true
                        index.value = it
                    }
                    .size(cardSize)
                    .padding(start = 20.dp, top = 10.dp)
            ){
                CardDisplay(fakeCards[it])
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
            PostDisplay(fakeCards[index.value])
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDisplay(
    fakeCard: FakeCard
){
    val checked = remember { mutableStateOf(false) }
    Box(contentAlignment = Alignment.BottomEnd){
        Image(
            painter = rememberAsyncImagePainter(model = fakeCard.imageUrl),
            contentDescription = fakeCard.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ){
            Text(
                text = fakeCard.author,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .weight(3f)
                    .align(Alignment.CenterVertically),
            )
            IconToggleButton(
                modifier = Modifier.weight(1f),
                checked = checked.value,
                onCheckedChange = {
                    checked.value = !checked.value
                }
            ) {
                Icon(if (checked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder, contentDescription = "Fave")
            }
        }
    }

}


@Composable
fun PostDisplay(
    fakeCard: FakeCard
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ){
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                painter = rememberAsyncImagePainter(model=fakeCard.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )

            Column (
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
            ){
                Text(text = fakeCard.title, color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = fakeCard.content, color = Color.DarkGray.copy(alpha = 0.5f), fontSize = 22.sp, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(30.dp))
//                Row {
//                    Image(
//                        modifier = Modifier
//                            .size(42.dp)
//                            .clip(CircleShape),
//                        painter = rememberAsyncImagePainter(model="https://image.geo.de/31549038/t/3T/v3/w1440/r1.5/-/sokrates-statue---adobestock-422840755.jpg"),
//                        contentDescription = null,
//                    )
//                    Spacer(modifier = Modifier.height( 10.dp))
//                    Text(text = "Author", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
//                }
            }
        }
    }
}