package com.oleksiikravchuk.taxcalculatorcanada.ui.income_tax_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import com.oleksiikravchuk.taxcalculatorcanada.R
import com.oleksiikravchuk.taxcalculatorcanada.data.Rates2024

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeTaxScreen(
    viewModel: ViewModel = IncomeTaxViewModel()
) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.28f)
        ) {
            Column(
                Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.province),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold
                    )
                    ProvinceSelector(
                        selectedProvince = Rates2024.provincesAndRates[0],
                        provinceList = Rates2024.provincesAndRates,
                        onProvinceSelected = {/*TODO*/ }
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Annual Income:",
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        placeholder = { Text(text = "100000") },
                        suffix = { Text(text = "C$") },
                        singleLine = true,
                        modifier = Modifier.padding(0.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropDownCircle,
                            contentDescription = ""
                        )
                        Text(text = "Income Options", modifier = Modifier.padding(start = 4.dp))
                    }


                    YearSelector(selectedYear = "2024", onYearSelected = { /*TODO*/ })

                    val yearsList = listOf(2023, 2024)

//                    ExposedDropdownMenuBox(
//                        expanded = expanded,
//                        onExpandedChange = { expanded = it },) {
//                        Text(text = "2024", fontSize = 24.sp)
//                        ExposedDropdownMenu(
//                            expanded = expanded,
//                            onDismissRequest = { expanded = false }) {
//                            yearsList.forEach {
//                                DropdownMenuItem(text = { it.toString() }, onClick = { /*TODO*/ })
//                            }
//                        }
//                    }

                }
            }
        }

    }
}

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
            text = "Year:",
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
                                onClick = { onYearSelected(it) },
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


@Preview
@Composable
fun ScreenPreview() {
    IncomeTaxScreen()
}
