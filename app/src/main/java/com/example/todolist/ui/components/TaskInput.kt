package com.example.todolist.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskInput(onAdd: (String) -> Unit) {
    var texto by remember { mutableStateOf("") }

    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = texto,
            onValueChange = { texto = it },
            modifier = Modifier.weight(1f),
            label = { Text("Nova tarefa") }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            onAdd(texto)
            texto = ""
        }) {
            Text("Adicionar")
        }
    }
}
