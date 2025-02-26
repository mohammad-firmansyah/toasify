package com.mostrans.toasify.component

import LoadingToastBar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mostrans.toasify.R
import com.mostrans.toasify.ui.Danger3
import com.mostrans.toasify.ui.Info3
import com.mostrans.toasify.ui.Neutral2
import com.mostrans.toasify.ui.Neutral3
import com.mostrans.toasify.ui.Neutral5
import com.mostrans.toasify.ui.Primary2
import com.mostrans.toasify.ui.Primary3
import com.mostrans.toasify.ui.Warning3
import com.mostrans.toasify.utils.ToastType


@Composable
fun CustomToast(
    title: String = "",
    message: String = "",
    type: ToastType = ToastType.Info,
    leadingIcon: ImageVector? = null,
    traillingIcon: ImageVector? = null,
    modifier: Modifier = Modifier,
    content: (@Composable () -> Unit)? = null,
) {
    when (type) {
        ToastType.Success -> {
            ToastSuccess(
                modifier = modifier,
                title = title,
                message = message
            )
        }

        ToastType.Error -> {
            ToastDanger(modifier = modifier)
        }

        ToastType.Warning -> {
            ToastWarning(modifier = modifier)
        }

        ToastType.Default -> {
            ToastSuccess()
        }

        ToastType.Loading -> {
            ToastLoading(
                modifier = modifier,
                message = title
            )
        }

        ToastType.Custom -> {
            ToastCustom {
                if (content != null) {
                    content()
                }
            }
        }

        ToastType.Info -> ToastInfo(
            modifier = modifier,
            title = title,
            message = message
        )
    }
}

@Composable
fun ToastSuccess(
    modifier: Modifier = Modifier,
    title: String = "Success",
    message: String = "Update Success",
) {
    Column(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral2, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp
                )
            )
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
            ) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = stringResource(R.string.new_notification),
                    tint = Primary3,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))

                Column(
                    Modifier.fillMaxWidth(0.8f)
                ) {

                    Text(
                        text = title,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = message,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        color = MaterialTheme.colorScheme.onBackground,

                        )
                }

            }



            Icon(
                Icons.Outlined.Close,
                contentDescription = stringResource(R.string.close_notification),
                tint = Neutral3,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Primary3)
        )
    }
}

@Composable
fun ToastLoading(modifier: Modifier = Modifier, message: String = "Loading") {
    Column(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral5, MaterialTheme.shapes.small)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 60.dp)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                Modifier.fillMaxWidth(0.8f)
            ) {


                Text(
                    text = message,
                    fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    color = Neutral5,

                    )
            }





            CircularProgressIndicator(
                color = Primary2,
                strokeWidth = 2.dp,
                modifier = Modifier.size(20.dp)
            )
        }

    }


}


@Composable
fun ToastInfo(
    modifier: Modifier = Modifier,
    title: String = "Info",
    message: String = "",
) {

    Column(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral2, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp
                )
            )
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
            ) {
                Icon(
                    Icons.Outlined.Info,
                    contentDescription = stringResource(R.string.new_notification),
                    tint = Info3,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))

                Column(
                    Modifier.fillMaxWidth(0.8f)
                ) {

                    Text(
                        text = title,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = message,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

            }



            Icon(
                Icons.Outlined.Close,
                contentDescription = stringResource(R.string.close_notification),
                tint = Neutral3,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Info3)
        )
    }
}

@Composable
fun ToastDanger(
    modifier: Modifier = Modifier,
    title: String = "Danger",
    message: String = "",
) {
    Column(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral2, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp
                )
            )
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "new notification",
                    tint = Danger3,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))

                Column(
                    Modifier.fillMaxWidth(0.8f)
                ) {

                    Text(
                        text = title,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = message,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

            }



            Icon(
                Icons.Outlined.Close,
                contentDescription = "close notification",
                tint = Neutral3,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Danger3)
        )
    }
}


@Composable
fun ToastWarning(
    modifier: Modifier = Modifier,
    title: String = "Warning",
    message: String = "",
) {
    Column(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .border(1.dp, Neutral2, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp
                )
            )
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .padding(horizontal = 8.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
            ) {
                Icon(
                    Icons.Default.Warning,
                    contentDescription = "new notification",
                    tint = Warning3,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))

                Column(
                    Modifier.fillMaxWidth(0.8f)
                ) {

                    Text(
                        text = title,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = message,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

            }



            Icon(
                Icons.Outlined.Close,
                contentDescription = "close notification",
                tint = Neutral3,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(Warning3)
        )
    }
}


@Composable
fun ToastCustom(
    content: @Composable () -> Unit,
) {
    content()
}

@Preview(showBackground = true)
@Composable
fun CustomToastPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier
            .fillMaxSize()
            .background(Neutral2)
            .padding(14.dp)
    ) {

        ToastSuccess(message = "Yuhuuu Sukesss")

        ToastLoading(message = "Tunggu Dulu Ya...")

        ToastInfo(message = "Just for your info ya...")

        ToastDanger(message = "Hati-hati bang!!!")

        ToastWarning(message = "Warning Cuiyyyy")

        ToastCustom(
            content = {
                Column(
                    modifier = Modifier
                        .zIndex(Float.MAX_VALUE)
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 50.dp)
                        .border(1.dp, Neutral2, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                        .background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 50.dp)
                            .padding(horizontal = 8.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                        ) {
                            Text("\uD83E\uDD84")

                            Spacer(Modifier.width(8.dp))

                            Column(
                                Modifier.fillMaxWidth(0.8f)
                            ) {

                                Text(
                                    text = "Customized Toast",
                                    fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                Spacer(Modifier.height(4.dp))

                                Text(
                                    text = "Customize Your Toast Freely",
                                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }

                        }



                        Icon(
                            Icons.Outlined.Close,
                            contentDescription = "close notification",
                            tint = Neutral3,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    LoadingToastBar()
                }
            }
        )
    }

}