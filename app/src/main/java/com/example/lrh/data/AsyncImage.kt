package com.example.lrh.data

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lrh.R


@Composable
fun AsyncImageI(
    url: String,
    modifier: Modifier = Modifier
){
    val imageBytes = decodeBase64Image(url)
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(imageBytes)
            .crossfade(true)
            .build(),
        contentDescription = null,
        placeholder = painterResource(R.drawable.plainblue),
        error = painterResource(R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop,
        modifier = modifier.size(50.dp)
            .clip(CircleShape)
    )
}

@Composable
fun AsyncImage(
    url: String,
    modifier: Modifier = Modifier
){
    val imageBytes = decodeBase64Image(url)
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(imageBytes)
            .crossfade(true)
            .build(),
        contentDescription = null,
        placeholder = painterResource(R.drawable.plainblue),
        error = painterResource(R.drawable.plainblue),
        contentScale = ContentScale.Crop,
        modifier = modifier.size(45.dp)
            .clip(RectangleShape)
    )
}

@Composable
fun AsyncImageII(
    url: String,
    modifier: Modifier = Modifier
){
    val imageBytes = decodeBase64Image(url)
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(imageBytes)
            .crossfade(true)
            .build(),
        contentDescription = null,
        placeholder = painterResource(R.drawable.plainblue),
        error = painterResource(R.drawable.plainblue),
        contentScale = ContentScale.Fit,
        modifier = modifier.size(45.dp)
            .clip(RectangleShape)
    )
}

fun decodeBase64Image(
    base64: String
): ByteArray{
    val pureBase64 = base64.substringAfter(",")
    return android.util.Base64.decode(pureBase64, android.util.Base64.DEFAULT)
}