package com.oleksiikravchuk.taxcalculatorcanada.ui.income_tax_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.oleksiikravchuk.taxcalculatorcanada.R

@Composable
fun YearSelector(selectedYear: String, onYearSelected: (Int) -> Unit) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    val yearsList = listOf(2023, 2024)


    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable { showDialog = true }
            .padding(8.dp)

    ) {
        Text(
            text = stringResource(R.string.year),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = selectedYear,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp
        )

        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {

                Surface(Modifier.clip(RoundedCornerShape(20.dp))) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        yearsList.forEach {
                            FilledTonalButton(
                                onClick = {
                                    onYearSelected(it)
                                    showDialog = false
                                },
                                modifier = Modifier.padding(bottom = 8.dp)
                            ) {
                                Text(
                                    text = it.toString(),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                            }
                        }

                    }
                }

            }
        }

    }
}