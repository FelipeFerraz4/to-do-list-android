package com.example.todolist.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import com.example.todolist.model.Task
import com.example.todolist.ui.components.TaskInput
import com.example.todolist.ui.components.TaskItem

@Composable
fun TaskListScreen() {
    val tasks = remember { mutableStateListOf<Task>() }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        TaskInput(onAdd = { title ->
            if (title.isNotBlank()) {
                tasks.add(Task(title))
            }
        })

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOf(task)
                        if (index != -1) {
                            tasks[index] = task.copy(completed = !task.completed)
                        }
                    },
                    onDelete = { tasks.remove(task) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
