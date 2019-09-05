package com.codemobiles.myauthen.models

data class TestJSON(
    val address: Address = Address(),
    val company: Company = Company(),
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val phone: String = "",
    val username: String = "",
    val website: String = ""
)

data class Address(
    val city: String = "",
    val geo: Geo = Geo(),
    val street: String = "",
    val suite: String = "",
    val zipcode: String = ""
)

data class Geo(
    val lat: String = "",
    val lng: String = ""
)

data class Company(
    val bs: String = "",
    val catchPhrase: String = "",
    val name: String = ""
)


