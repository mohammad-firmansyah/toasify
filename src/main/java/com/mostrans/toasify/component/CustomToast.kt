package com.mostrans.toasify.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mostrans.toasify.ui.Black
import com.mostrans.toasify.ui.Danger3
import com.mostrans.toasify.ui.Neutral1
import com.mostrans.toasify.ui.Neutral2
import com.mostrans.toasify.ui.Neutral5
import com.mostrans.toasify.ui.Primary3
import com.mostrans.toasify.ui.ToasifyTheme
import com.mostrans.toasify.ui.Warning3
import com.mostrans.toasify.utils.ToastType


@Composable
fun CustomToast(message: String, type: ToastType) {
    val backgroundColor = when (type) {
        ToastType.Success -> Primary3
        ToastType.Error -> Danger3
        ToastType.Warning -> Warning3
        ToastType.Default -> Neutral1
        ToastType.Loading -> Neutral5
        ToastType.Custom -> Black
    }

    Column(
        modifier = Modifier
            .zIndex(99999999f)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral2, RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
            .clip(
                RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 4.dp
                )
            )
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
            ) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "new notification",
                    tint = backgroundColor,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))
                Text(
                    text = message,
                    fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Icon(
                Icons.Outlined.Close,
                contentDescription = "close notification",
                tint = backgroundColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(backgroundColor)
        )
    }
}

@Preview
@Composable
fun CustomToastPreview() {
    ToasifyTheme {
        CustomToast(message = "This is a toast!", type = ToastType.Success)
    }
}