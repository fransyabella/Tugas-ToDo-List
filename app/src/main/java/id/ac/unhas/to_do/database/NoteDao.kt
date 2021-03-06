package id.ac.unhas.to_do.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Query("Select * from toDoList")
    fun getList(): LiveData<List<ToDoList>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(toDoList: ToDoList)

    @Delete
    suspend fun deleteList(toDoList: ToDoList)

    @Update
    suspend fun updateList(toDoList: ToDoList)

    @Query("SELECT * FROM toDoList ORDER BY deadline DESC, timeDeadline DESC")
    fun deadlineDesc() : LiveData<List<ToDoList>>

    @Query("SELECT * FROM toDoList ORDER BY deadline ASC, timeDeadline ASC")
    fun deadlineAsc() : LiveData<List<ToDoList>>

    @Query("SELECT * FROM toDoList ORDER BY date DESC")
    fun dateDesc() : LiveData<List<ToDoList>>

    @Query("SELECT * FROM toDoList ORDER BY date ASC")
    fun dateAsc() : LiveData<List<ToDoList>>

    @Query("SELECT * FROM toDoList WHERE toDoList LIKE :toDoList")
    fun search(toDoList: String) : LiveData<List<ToDoList>>
}