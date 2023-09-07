package com.todoapp.todo_app

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.todoapp.todo_app.databinding.ActivityMainBinding


class MyAdapter2(private val context: Context, val itemList: ArrayList<MyData>) :
    RecyclerView.Adapter<MyAdapter2.BoardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].todo_text
        when(itemList[position].item_check){
            0->{
                holder.check_view.setImageResource(R.drawable.circle_off)
            }
            1->{

                holder.check_view.setImageResource(R.drawable.circle_on)
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
    fun set(){
        notifyDataSetChanged()
    }



    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.todo_item)
        val check_view = itemView.findViewById<ImageView>(R.id.imageView)
    }


}