package com.oleksiikravchuk.taxcalculatorcanada.ui.income_tax_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.oleksiikravchuk.taxcalculatorcanada.data.Rates2024
import com.oleksiikravchuk.taxcalculatorcanada.models.Province
import com.oleksiikravchuk.taxcalculatorcanada.ui.util.getProvinceFlagDrawableId

@Composable
fun ProvinceSelector(
    selectedProvince: Province,
    provinceList: Array<Province>,
    onProvinceSelected: (Province) -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                showDialog = true
            }
            .padding(4.dp)

    ) {
        Text(
            text = selectedProvince.provinceName,
            modifier = Modifier.padding(end = 16.dp)
        )
        Image(
            painter = painterResource(id = getProvinceFlagDrawableId(selectedProvince.provinceName)),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,

            modifier = Modifier
                .width(60.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(8.dp))

        )
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(Modifier.clip(RoundedCornerShape(20.dp))) {
                LazyColumn(Modifier.padding(8.dp)) {
                    items(provinceList) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .clickable {
                                    onProvinceSelected(it)
                                    showDialog = false
                                }
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 8.dp)

                        ) {
                            Text(
                                text = it.provinceName,
                            )
                            Image(
                                painter = painterResource(id = getProvinceFlagDrawableId(it.provinceName)),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,

                                modifier = Modifier
                                    .width(60.dp)
                                    .height(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProvinceSelectorPreview() {
    Surface {
        ProvinceSelector(
            selectedProvince = Rates2024.provincesAndRates[0],
            provinceList = Rates2024.provincesAndRates,
            onProvinceSelected = {})
    }
}