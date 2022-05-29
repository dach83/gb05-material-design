package com.example.gb05_material_design.presentation.todo_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gb05_material_design.R
import com.example.gb05_material_design.databinding.FragmentTodoListBinding
import com.example.gb05_material_design.domain.model.todo_list.TodoImageItem
import com.example.gb05_material_design.domain.model.todo_list.TodoItem
import com.example.gb05_material_design.domain.model.todo_list.TodoTextItem
import com.example.gb05_material_design.domain.model.todo_list.randomTodoList
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {

    private val binding by viewBinding(FragmentTodoListBinding::bind)

    private val adapter = ListDelegationAdapter<List<TodoItem>>(
        todoTextAdapterDelegate(::onClickTodoTextItem),
        todoImageAdapterDelegate(::onClickTodoImageItem),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter.items = randomTodoList(30)
        binding.todoRecyclerView.adapter = adapter
    }

    private fun onClickTodoTextItem(item: TodoTextItem) {
        Toast.makeText(context, "Click text", Toast.LENGTH_SHORT).show()
    }

    private fun onClickTodoImageItem(item: TodoImageItem) {
        Toast.makeText(context, "Click image", Toast.LENGTH_SHORT).show()
    }

}
