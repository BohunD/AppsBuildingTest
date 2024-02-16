package com.bohunapps.appsbuildingtest.presentation


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bohunapps.appsbuildingtest.repository.SharedPrefsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: SharedPrefsRepo
): ViewModel() {
    private val _currentName = MutableStateFlow("")
    val currentName: Flow<String> get() = _currentName

    private val _currentAge = MutableStateFlow("")
    val currentAge: Flow<String> get() = _currentAge

    private val _nameFromPrefs = MutableStateFlow("")
    val nameFromPrefs: Flow<String> get() = _nameFromPrefs

    private val _ageFromPrefs = MutableStateFlow("")
    val ageFromPrefs: Flow<String> get() = _ageFromPrefs

    private val _numIsCorrect = mutableStateOf(true)
    val ageIsCorrect: State<Boolean>
        get() = _numIsCorrect


    fun setCurrentName(name: String){
        _currentName.value = name
    }

    fun validateAge(age: String) {
        _numIsCorrect.value = !(age.isEmpty() || !isDigit(age))
    }
    private fun isDigit(value: String): Boolean {
        return value.all { it.isDigit() }
    }
    fun setCurrentAge(age: String){
        validateAge(age)
        _currentAge.value = age
    }

    fun saveName(){
        repo.saveName(_currentName.value)
    }

    fun saveAge(){
        repo.saveAge(_currentAge.value)
    }

    fun loadFromSharedPreferences() {
        _currentName.value = ""
        _currentAge.value = ""
        viewModelScope.launch(Dispatchers.IO) {
            val name = repo.getName() ?: ""
            _nameFromPrefs.value = name

            val age = repo.getAge().toString()
            _ageFromPrefs.value = age
        }
    }

}