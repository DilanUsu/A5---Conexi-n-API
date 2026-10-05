package com.example.retrofit_demmo.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Coffee(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("ingredients") val ingredients: JsonElement?,
    @SerializedName("image") val image: String?
) {
    val ingredientList: List<String>
        get() = when {
            ingredients == null || ingredients.isJsonNull -> emptyList()
            ingredients.isJsonArray -> ingredients.asJsonArray.map { it.asString }
            else -> listOf(ingredients.asString)
        }
}
