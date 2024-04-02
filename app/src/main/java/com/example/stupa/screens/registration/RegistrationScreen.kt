package com.example.stupa.screens.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stupa.component.CountryDropDown
import com.example.stupa.ui.theme.StupaTheme

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel? = hiltViewModel()
) {
  val context = LocalContext.current
  val focusManager = LocalFocusManager.current

  var name by remember { mutableStateOf("") }
  var phoneNumber by remember { mutableStateOf("") }
  var country by remember { mutableStateOf(Country.INDIA.displayName) }
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Register", style = MaterialTheme.typography.headlineMedium)

    Spacer(modifier = Modifier.height(32.dp))

    TextField(
      value = name,
      onValueChange = { name = it },
      label = { Text("Name") },
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
      value = phoneNumber,
      onValueChange = { phoneNumber = it },
      label = { Text("Phone Number") },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Next
      ),
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Down)
        }
      )
    )

    Spacer(modifier = Modifier.height(16.dp))

    CountryDropDown(
      selectedCountry = country,
      onCountrySelected = {
        country = it
      }
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
      value = email,
      onValueChange = { email = it },
      label = { Text("Email") },
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    TextField(
      value = password,
      onValueChange = { password = it },
      label = { Text("Password") },
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(32.dp))

    Button(onClick = {
      val formData = RegistrationFormData(
        name = name,
        phoneNumber = phoneNumber,
        country = country,
        email = email,
        password = password
      )
    }) {
      Text("Register")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  StupaTheme {
    RegistrationScreen(navController = rememberNavController())
  }
}