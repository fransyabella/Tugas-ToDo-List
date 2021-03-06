package id.ac.unhas.to_do.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.unhas.to_do.database.ToDoList
import id.ac.unhas.to_do.database.ToDoListRepository

class ViewModel(application: Application) : AndroidViewModel(application) {

    private var toDoListRepository = ToDoListRepository(application)
    private var toDoList: LiveData<List<ToDoList>>? = toDoListRepository.getList()

    fun insertList(toDoList:ToDoList) {
        toDoListRepository.insert(toDoList)
    }

    fun getList(): LiveData<List<ToDoList>>? {
        return toDoList
    }

    fun deleteList(toDoList: ToDoList) {
        toDoListRepository.delete(toDoList)
    }

    fun updateList(toDoList: ToDoList) {
        toDoListRepository.update(toDoList)
    }

    fun deadlineDesc():LiveData<List<ToDoList>>? {
        return toDoListRepository.deadlineDesc()
    }

    fun deadlineAsc():LiveData<List<ToDoList>>? {
        return toDoListRepository.deadlineAsc()
    }

    fun dateDesc():LiveData<List<ToDoList>>? {
        return toDoListRepository.dateDesc()
    }

    fun dateAsc():LiveData<List<ToDoList>>? {
        return toDoListRepository.dateAsc()
    }

    fun search(toDoList: String):LiveData<List<ToDoList>>?{
        return toDoListRepository.search(toDoList)
    }

}