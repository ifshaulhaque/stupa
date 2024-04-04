package com.example.stupa.screens.registration

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*

enum class Country(val displayName: String) {
    USA("United States"),
    CANADA("Canada"),
    UK("United Kingdom"),
    AUSTRALIA("Australia"),
    INDIA("India")
}