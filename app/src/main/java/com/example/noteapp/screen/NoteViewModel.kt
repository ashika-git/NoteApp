package com.example.noteapp.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NewDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor( private val repository: NoteRepository) :ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    var noteList= _noteList.asStateFlow()
//    private var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch (Dispatchers.IO){ 
            repository.getAllNotes().distinctUntilChanged()
                .collect{listOfNotes->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", ":empty list")
                    }else{
                        _noteList.value = listOfNotes
                    }
                    
                }
        }
//        noteList.addAll(NewDataSource().loadNotes())
    }
//
//    fun addNote(note: Note){
//        noteList.add(note)
//    }
    
    fun addNote(note: Note) = viewModelScope.launch {
        repository.addNote(note)
    }
    
    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }
    
     fun removeNote(note: Note)= viewModelScope.launch {
        repository.deleteNote(note)
    }

//    fun removeNote(note: Note){
//        noteList.remove(note)
//    }

//    fun getAllNotes() : List<Note>{
//        return noteList
//    }
}