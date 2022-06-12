package ba.ibu.gram.ui.components

import android.content.res.Configuration
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Shapes
import androidx.compose.material3.Shapes.Companion
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.ibu.gram.R
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.screens.user
import ba.ibu.gram.ui.theme.AppTheme
import coil.compose.rememberAsyncImagePainter

val post = Post(
  1,
  "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
  "1",
  "Sample description",
  420,
  null
)

@Composable
fun PostTile(post: Post, modifier: Modifier = Modifier,  onClick: () -> Unit = {}) {
  val postImage = rememberAsyncImagePainter(post.photoUrl)

  Image(
    painter = postImage,
    contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = modifier
      .clickable { onClick() }
      .fillMaxWidth()
      .aspectRatio(1f)
  )
}

@Preview(
  name = "PostTile",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PostTileDefaultPreview() {
  AppTheme {
    PostTile(post)
  }
}

@Preview(
  name = "SearchBar Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PostTileDarkDefaultPreview() {
  AppTheme {
    PostTile(post)
  }
}