package id.ac.unhas.to_do.database

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ToDoListRepository(application: Application) {

    private val noteDao: NoteDao?
    private var note: LiveData<List<ToDoList>>? = null

    init {
        val db = AppDatabase.getInstance(application.applicationContext)
        noteDao = db?.noteDao()
        note = noteDao?.getList()
    }

    fun getList(): LiveData<List<ToDoList>>? {
        return note
    }

    fun insert(toDoList: ToDoList) = runBlocking {
        this.launch(Dispatchers.IO) {
            noteDao?.insertList(toDoList)
        }
    }

    fun delete(toDoList: ToDoList) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                noteDao?.deleteList(toDoList)
            }
        }
    }

    fun update(toDoList: ToDoList) = runBlocking {
        this.launch(Dispatchers.IO) {
            noteDao?.updateList(toDoList)
        }
    }

    fun deadlineDesc() : LiveData<List<ToDoList>>?{
        return noteDao?.deadlineDesc()
    }

    fun deadlineAsc() : LiveData<List<ToDoList>>?{
        return noteDao?.deadlineAsc()
    }

    fun dateDesc() : LiveData<List<ToDoList>>?{
        return noteDao?.dateDesc()
    }

    fun dateAsc() : LiveData<List<ToDoList>>?{
        return noteDao?.dateAsc()
    }

    fun search(toDoList: String) : LiveData<List<ToDoList>>?{
        return noteDao?.search(toDoList)
    }
}