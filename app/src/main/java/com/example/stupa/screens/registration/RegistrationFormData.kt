package com.example.stupa.screens.registration

data class RegistrationFormData(
    var name: String = "",
    var phoneNumber: String = "",
    var country: String = Country.INDIA.displayName,
    var email: String = "",
    var password: String = ""
)