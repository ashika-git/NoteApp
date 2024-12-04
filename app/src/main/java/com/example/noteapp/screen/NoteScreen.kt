package com.example.noteapp.screen

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.NoteButton
import com.example.noteapp.components.NoteInputField
import com.example.noteapp.data.NewDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.ui.theme.NoteAppTheme
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,

){
    val context = LocalContext.current
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon")
            },
            colors = TopAppBarDefaults.topAppBarColors().copy(Color(0xFFDADFE3))

        )

        //Content
        Column(
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            NoteInputField(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = title ,
                label = "Title" ,
                onTextChange = {
                    if(it.all { char ->
                        char.isLetter()|| char.isWhitespace()
                        }) title = it
                }
            )

            NoteInputField(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = description ,
                label = "Add a note" ,
                onTextChange = {

                    if(it.all { char ->
                            char.isLetter()|| char.isWhitespace()
                        }) description  = it
                }
            )

            NoteButton(text = "Save",
                onClick = {
                    if(title.isNotEmpty() && description.isNotEmpty()){

                        // save btn
                        onAddNote(Note(
                            title = title,
                            description = description ))
                        title = ""
                        description = ""

                        Toast.makeText(
                            context,
                            "Note Added",
                            Toast.LENGTH_SHORT
                        ).show()
                     }
                }

            )

            //Divider
            Divider(modifier = Modifier.padding(10.dp))

            LazyColumn {
               items(notes){ note ->
                   NoteRow(note = note,
                       onNoteClicked = {
                           onRemoveNote(note)
                       }
                   )
               }
            }

        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
){

    Surface(modifier.padding(8.dp)
        .clip(RoundedCornerShape(topEnd = 24.dp, bottomStart = 24.dp))
        .fillMaxWidth(),
        color = Color(0xFF8C8383),
//        color = Color(OxFFDFE6EB),
        shadowElevation = 6.dp
    ){
        Column(modifier
            .clickable {
                onNoteClicked(note)
            }
            .padding(horizontal = 14.dp,
                vertical = 6.dp),
            horizontalAlignment = Alignment.Start
            ) {
            Text(text = note.title,
                style = MaterialTheme.typography.bodyMedium)
            Text(text = note.description,
                style = MaterialTheme.typography.bodySmall)
//            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
//                style = MaterialTheme.typography.caption)
        }
    }

}



@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteAppTheme {
        NoteScreen(notes = NewDataSource().loadNotes(), onAddNote = {}, {})
    }
}