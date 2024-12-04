package com.example.noteapp.components

import android.widget.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun NoteInputField(
    modifier: Modifier = Modifier,
    text : String,
    label: String,
    maxLine: Int = 1,
    onTextChange :(String) -> Unit,
    onImeAction: () -> Unit = {}
){

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        maxLines = maxLine,
        onValueChange = onTextChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F1F1),
            unfocusedContainerColor = Color(0xFFA6A2A2),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedLabelColor = Color.LightGray,
            focusedIndicatorColor = Color.DarkGray,

            )
    )

}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled :Boolean = true
){
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
        ) {
        Text(text)
    }
}





