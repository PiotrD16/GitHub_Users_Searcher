package com.example.githubsearch.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.data.model.User
import com.example.githubsearch.data.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val userState: StateFlow<List<User>> = _searchQuery
        .debounce(500)   // timeout, wait 0.5s until user stops typing
        .filter { t -> t.length >= 3} // at least 3 letters before searching
        .distinctUntilChanged()       // display only if sth changed
        .mapLatest {query -> userRepository.searchUser(query)}
        .stateIn(
            scope = viewModelScope,  // it lives as long as viewmodel
            started = SharingStarted.WhileSubscribed(5000), // this is for battery save
            initialValue = emptyList()  // we start with empty list - stateflow always has current state
        )

    fun searchQuery(newQuery: String) {
        _searchQuery.value = newQuery
    }
}