package com.hexware.battleground.foundation.models

/**
 * Model definition for how a Todo coming
 * from the json placeholder todos api should look
 * like.
 *
 * This will be used when turning JSON data into an object
 * and vice versa.
 *
 * Retrofit will nicely know how to Serialize and
 * Deserialize because of the ConverterFactory it has
 * been provided on initialization. More details on that
 * at foundation.RetrofitInstance
 */
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
