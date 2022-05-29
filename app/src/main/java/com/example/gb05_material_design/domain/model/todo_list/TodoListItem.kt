package com.example.gb05_material_design.domain.model.todo_list

import java.util.*

sealed class TodoItem(val id: UUID = UUID.randomUUID())

data class TodoTextItem(val text: String) : TodoItem()
data class TodoImageItem(val url: String) : TodoItem()

fun randomTextItem(): TodoTextItem {
    when (Random().nextInt(10)) {
        0 -> "Take a picture of an old camera that can't take pictures anymore."
        1 -> "Play frisbee golf with old CDs or DVDs you don't care about."
        2 -> "Close the fridge really slowly to see when the light goes out."
        3 -> "Take a nap under a shady tree. Like, a tree with shade. Not like, a sketchy, creepy tree. Don't do that."
        4 -> "Count the squirrels at your local park. If your park has no squirrels, just sit there and think about life."
        5 -> "Volunteer in your community by becoming one of those garbage stabber people."
        6 -> "Plant carrots. Grow carrots. Pick carrots. Wash carrots. Eat carrots."
        7 -> "Have a parade with just you walking down the street playing a kazoo. Maybe have your dog in there too."
        8 -> "Try to run for a really long time like Forrest Gump but then stop after maybe a block or two."
        9 -> "Freeze a milkshake so it can just be regular ice cream in cylinder form. Mmm, cylinders."
        else -> "Microwave something, then open the microwave at 1 second left and pretend you disabled a bomb."
    }.also {
        return TodoTextItem(it)
    }
}

fun randomImageItem(): TodoImageItem {
    val randomHeight = 600 + Random().nextInt(300)
    return TodoImageItem("https://picsum.photos/500/$randomHeight")
}

fun randomTodoItem(): TodoItem = when (Random().nextBoolean()) {
    true -> randomTextItem()
    false -> randomImageItem()
}

fun randomTodoList(count: Int): List<TodoItem> = (1..count).map { randomTodoItem() }
