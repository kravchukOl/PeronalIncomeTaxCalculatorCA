package com.oleksiikravchuk.taxcalculatorcanada.ui.income_tax_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
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
                        text = stringResource(R.string.annual_income),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        placeholder = { Text(text = "100000") },
                        suffix = { Text(text = stringResource(R.string.can_dollar)) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
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

                }
            }
        }

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .padding(20.dp)
            ) {

                ExpandableContainer(isExpanded = false,
                    title = {
                        Text(
                            text = "Add RRSP Contribution",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onTitleClick = {}) {

                    OutlinedTextField(
                        value = "", onValueChange = {},

                        prefix = { Text(text = "C$") },
                        singleLine = true,
                        modifier = Modifier.padding(0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        placeholder = {
                            Text(
                                text = "RRSP Contribution",
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
                ExpandableContainer(isExpanded = false,
                    title = {
                        Text(
                            text = "Add Capital Gains",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onTitleClick = {}) {
                    OutlinedTextField(
                        value = "", onValueChange = {},

                        prefix = { Text(text = "C$") },
                        singleLine = true,
                        modifier = Modifier.padding(0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        placeholder = {
                            Text(
                                text = "Capital Gains",
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

                ExpandableContainer(isExpanded = false,
                    title = {
                        Text(
                            text = "Add Eligible Dividends",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onTitleClick = {}) {

                    OutlinedTextField(
                        value = "", onValueChange = {},

                        prefix = { Text(text = "C$") },
                        singleLine = true,
                        modifier = Modifier.padding(0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        placeholder = {
                            Text(
                                text = "Eligible Dividends",
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

                ExpandableContainer(isExpanded = false,
                    title = {
                        Text(
                            text = "Add Non-eligible Dividends",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onTitleClick = {}) {
                    OutlinedTextField(
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

    }
}


@Preview
@Composable
fun ScreenPreview() {
    IncomeTaxScreen()
}
