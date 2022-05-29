package com.example.gb05_material_design.presentation.todo_list

import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.gb05_material_design.databinding.ItemImageTodoBinding
import com.example.gb05_material_design.databinding.ItemTextTodoBinding
import com.example.gb05_material_design.domain.model.todo_list.TodoImageItem
import com.example.gb05_material_design.domain.model.todo_list.TodoItem
import com.example.gb05_material_design.domain.model.todo_list.TodoTextItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun todoTextAdapterDelegate(onClickItem: (TodoTextItem) -> Unit) =
    adapterDelegateViewBinding<TodoTextItem, TodoItem, ItemTextTodoBinding>(
        { layoutInflater, root -> ItemTextTodoBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener { onClickItem(item) }
        bind {
            binding.todoTextView.text = item.text
        }
    }

fun todoImageAdapterDelegate(onClickItem: (TodoImageItem) -> Unit) =
    adapterDelegateViewBinding<TodoImageItem, TodoItem, ItemImageTodoBinding>(
        { layoutInflater, root -> ItemImageTodoBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener { onClickItem(item) }
        bind {
            binding.todoImageView.load(item.url)
        }
    }

