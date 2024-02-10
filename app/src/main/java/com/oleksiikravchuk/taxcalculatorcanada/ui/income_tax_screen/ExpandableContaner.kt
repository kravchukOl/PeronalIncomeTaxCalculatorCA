package com.oleksiikravchuk.taxcalculatorcanada.ui.income_tax_screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ExpandableContainer(
    isExpanded: Boolean,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = {},
    openIcon: @Composable () -> Unit = ExpandableContainerDefaults.openIcon,
    closeIcon: @Composable () -> Unit = ExpandableContainerDefaults.closeIcon,
    onTitleClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    var expanded: Boolean by remember {
        mutableStateOf(isExpanded)
    }
    Column(
        modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable {
                    expanded = !expanded
                    onTitleClick()
                }
                .padding(vertical = 8.dp, horizontal = 4.dp)
        ) {
            if (expanded)
                closeIcon()
            else
                openIcon()

            title()
        }
        if (expanded) {
            content()
        }
    }
}

sealed class ExpandableContainerDefaults {

    companion object {
        val openIcon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.ExpandMore,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        val closeIcon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.ExpandLess,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun ExpandableContainerPreview() {
    Surface {
        ExpandableContainer(
            isExpanded = false,
            title = {
                Text(
                    text = "Add Non-eligibleDividends",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            onTitleClick = {}
        ) {
            TextField(
                value = "", onValueChange = {},
                prefix = { Text(text = "C$") },
                singleLine = true,
                modifier = Modifier.padding(0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                placeholder = {
                    Text(
                        text = "Non-eligible Dividends",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.TwoTone.Info,
                        contentDescription = ""
                    )
                }
            )
        }
    }
}
