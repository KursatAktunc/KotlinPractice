package com.kotlin.practice.models.pokedex

import com.google.gson.annotations.SerializedName

data class Pokemon(

    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("imageurl") var imageurl: String? = null,
    @SerializedName("xdescription") var xdescription: String? = null,
    @SerializedName("ydescription") var ydescription: String? = null,
    @SerializedName("height") var height: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("weight") var weight: String? = null,
    @SerializedName("typeofpokemon") var typeofpokemon: ArrayList<String> = arrayListOf(),
    @SerializedName("weaknesses") var weaknesses: ArrayList<String> = arrayListOf(),
    @SerializedName("evolutions") var evolutions: ArrayList<String> = arrayListOf(),
    @SerializedName("abilities") var abilities: ArrayList<String> = arrayListOf(),
    @SerializedName("hp") var hp: Int? = null,
    @SerializedName("attack") var attack: Int? = null,
    @SerializedName("defense") var defense: Int? = null,
    @SerializedName("special_attack") var specialAttack: Int? = null,
    @SerializedName("special_defense") var specialDefense: Int? = null,
    @SerializedName("speed") var speed: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("male_percentage") var malePercentage: String? = null,
    @SerializedName("female_percentage") var femalePercentage: String? = null,
    @SerializedName("genderless") var genderless: Int? = null,
    @SerializedName("cycles") var cycles: String? = null,
    @SerializedName("egg_groups") var eggGroups: String? = null,
    @SerializedName("evolvedfrom") var evolvedfrom: String? = null,
    @SerializedName("reason") var reason: String? = null,
    @SerializedName("base_exp") var baseExp: String? = null

)