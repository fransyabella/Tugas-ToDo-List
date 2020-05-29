package id.ac.unhas.to_do.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.to_do.R
import id.ac.unhas.to_do.database.ToDoList
import kotlinx.android.synthetic.main.content_main.view.*

class Adapter(private val context: Context?, private val listener: (ToDoList, Int) -> Unit) :

    RecyclerView.Adapter<MyViewHolder>() {

    private var note = listOf<ToDoList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.content_main,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = note.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (context != null) {
            holder.bindItem(context, note[position], listener)
        }
    }

    fun setList(toDoList: List<ToDoList>) {
        this.note = toDoList
        notifyDataSetChanged()
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(context: Context, toDoList: ToDoList, listener: (ToDoList, Int) -> Unit) {
        val option :ImageView
        option=itemView.findViewById(R.id.option)
        itemView.noteContent.text = toDoList.note
        itemView.titleContent.text = toDoList.toDoList
        itemView.deadlineDateContent.text = toDoList.deadline
        itemView.deadlineTimeContent.text = toDoList.timeDeadline
        itemView.dateContent.text = toDoList.date
        option.setOnClickListener {
            listener(toDoList,layoutPosition)
        }
    }
}