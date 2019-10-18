package io.owuor91.domain.model

import com.google.gson.annotations.SerializedName

data class Note(var id: Int, var title: String, @SerializedName("noteText") var noteText: String) {
}