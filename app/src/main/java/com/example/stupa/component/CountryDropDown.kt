package com.example.stupa.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.stupa.screens.registration.Country

@Composable
fun CountryDropDown(
  selectedCountry: String,
  onCountrySelected: (String) -> Unit
) {
  var expanded by remember { mutableStateOf(false) }

  Column {
    Text(
      text = selectedCountry,
      modifier = Modifier.fillMaxWidth()
    )
    Box(
      modifier = Modifier.fillMaxWidth()
    ) {
      TextButton(
        onClick = { expanded = true },
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(text = "Select your Country")
      }
      DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
      ) {
        Country.values().forEach { countryOption ->
          DropdownMenuItem(
            text = {
              Text(text = countryOption.displayName)
            },
            onClick = {
              onCountrySelected(countryOption.displayName)
              expanded = false
            }
          )
        }
      }
    }
  }
}
