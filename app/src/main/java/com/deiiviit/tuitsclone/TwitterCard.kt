package com.deiiviit.tuitsclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

var commentIcon by mutableIntStateOf(R.drawable.ic_chat)

var retweetIcon by mutableStateOf(R.drawable.ic_rt)

var likeIcon by mutableIntStateOf(R.drawable.ic_like)

var commentCount by mutableIntStateOf(0)

var retweetCount by mutableIntStateOf(0)

var likeCount by mutableIntStateOf(0)

var commentColor by mutableStateOf(Color.Gray)

var retweetColor by mutableStateOf(Color.Gray)

var likeColor by mutableStateOf(Color.Gray)


@Preview(showBackground = true, backgroundColor = 0xFF171F2B)
@Composable
fun TwitterCard() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
    ) {

        // put the image R.drawable.profile.jpg
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier
                .clip(CircleShape)
                .width(55.dp)
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(Modifier.weight(1f)) {
                    TextTitle("Aris", modifier = Modifier)
                    TextDefault(
                        "@AristiDevs",
                        Modifier.padding(horizontal = 4.dp),
                    )
                    TextDefault(
                        "4h", modifier = Modifier
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "More options",
                    Modifier.align(Alignment.CenterVertically),
                    tint = Color.White
                )
            }
            TextBody(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed euismod, nulla nec tempus ultrices, nulla nunc tincidunt nisl, " +
                        "nec ultrices lorem nisl vel nisl",
                Modifier.padding(vertical = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = "Image",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                createIconButton(
                    commentIcon,
                    "Comment",
                    commentColor,
                    commentCount,
                    modifier = Modifier,
                    ::updateCommentIconAndCount
                )
                createIconButton(
                    retweetIcon,
                    "Retweet",
                    retweetColor,
                    retweetCount,
                    modifier = Modifier,
                    ::updateRetweetIconAndCount
                )
                createIconButton(
                    likeIcon,
                    "Like",
                    likeColor,
                    likeCount,
                    modifier = Modifier,
                    ::updateLikeIconAndCount
                )
            }

        }
    }
}

@Composable
fun createIconButton(
    icon: Int,
    description: String,
    color: Color,
    counter: Int,
    modifier: Modifier,
    updateIconAndCount: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = modifier.width(32.dp),
            onClick = updateIconAndCount,
            content = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = description,
                    tint = color
                )
            },
        )
        Text(text = "$counter", color = Color.Gray)
    }
}

@Composable
private fun TextBody(text: String, modifier: Modifier) {
    Text(
        text,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun TextTitle(text: String, modifier: Modifier) {
    Text(text = text, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun TextDefault(text: String, modifier: Modifier) {
    Text(text = text, color = Color.Gray, modifier = modifier)
}

fun updateCommentIconAndCount() {
    commentIcon = if (commentIcon == R.drawable.ic_chat) {
        R.drawable.ic_chat_filled
    } else {
        R.drawable.ic_chat
    }
    commentCount = if (commentIcon == R.drawable.ic_chat_filled) {
        commentCount + 1
    } else {
        commentCount - 1
    }
}

fun updateRetweetIconAndCount() {
    retweetColor = if (retweetColor == Color.Gray) {
        Color.Green
    } else {
        Color.Gray
    }
    retweetCount = if (retweetColor == Color.Green) {
        retweetCount + 1
    } else {
        retweetCount - 1
    }
}

fun updateLikeIconAndCount() {
    likeIcon = if (likeIcon == R.drawable.ic_like) {
        R.drawable.ic_like_filled
    } else {
        R.drawable.ic_like
    }
    likeCount = if (likeIcon == R.drawable.ic_like_filled) {
        likeCount + 1
    } else {
        likeCount - 1
    }

    likeColor = if (likeIcon == R.drawable.ic_like_filled) {
        Color.Red
    } else {
        Color.Gray
    }
}