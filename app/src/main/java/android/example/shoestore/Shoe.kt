package android.example.shoestore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {
    override fun toString(): String {
        return "Company: $company\nName: $name\nSize: $size\nDescription: $description"
    }
}
