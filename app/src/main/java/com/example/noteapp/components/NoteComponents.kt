package com.example.noteapp.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


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
//    TextField(
//        value = text,
//        onValueChange = onTextChange ,
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.Transparent
//        ),
//        maxLine = maxLine,
//        label =  Text(text = label) ,
//        keyboardActions = KeyboardActions(
//            onDone = {
//                onImeAction()
//                keyboardController?.hide()  // Hide the keyboard when done
//            }
//        ),
//        keyboardController = {
//            onImeAction()
//            keyboardController?.hide()
//        },
//        modifier = modifier
//
//    )
//
//
//    TextField(
//        value = text,
//        maxLines = maxLine,
//        onValueChange   = onTextChange,
//        label = { Text(text = label) },
//        keyboardActions = KeyboardOptions.Default.copy(
//            imeAction = ImeAction.Done
//        ),
//        KeyboardActions = KeyboardActions(
//            onDone = { onImeAction()
//            keyboardController ?. hide () }),
//
//        modifier = Modifier
//    )

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
        )
    )

}





