package com.example.utsmobilecomputing

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utsmobilecomputing.model.Matkul

class MainActivity : ComponentActivity() {
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var matkulAmount = 0
            for (i in 1..1000) {
                if (resources.getIdentifier("matkul${i}", "string", packageName) == 0) {
                    break
                }
                matkulAmount = i
            }
            val matkulList = List(matkulAmount) { index ->
                Matkul(
                    matkulRes = resources.getIdentifier(
                        "matkul${index + 1}",
                        "string",
                        packageName
                    ),
                    sksRes = resources.getIdentifier("sks${index + 1}", "string", packageName),
                    logoRes = resources.getIdentifier("logo${index + 1}", "drawable", packageName)
                )
            }
            MyApp(matkulList)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(matkul: List<Matkul>) {
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.White,
            ),
            title = {
                Text(
                    "Daftar Matkul",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(matkul.size) {
                MatkulCard(matkul[it])
            }
        }
    }
}

@Composable
fun MatkulCard(matkul: Matkul) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = matkul.logoRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp)
            )
            Text(
                text = stringResource(id = matkul.matkulRes),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp, bottom = 0.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(id = matkul.sksRes),
                fontSize = 14.sp,
                modifier = Modifier.padding(10.dp),
                color = Color.DarkGray
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AppPreview() {
//    MyApp()
//}