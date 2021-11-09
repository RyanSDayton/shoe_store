package android.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _storedShoes = MutableLiveData<MutableList<Shoe>>()
    val storedShoes: LiveData<MutableList<Shoe>>
        get() = _storedShoes

    val name = MutableLiveData<String>()

    val company = MutableLiveData<String>()

    val size = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun saveShoe() {
        val shoe = Shoe(
            company = company.value ?: "No name for company",
            name = name.value ?: "No name for shoes",
            size = size.value.toString().toDoubleOrNull() ?: 0.0,
            description = description.value ?: "No description for shoes"
        )

        val currentList = _storedShoes.value
        currentList?.add(shoe)
        _storedShoes.postValue(currentList ?: mutableListOf(shoe))
    }
}
