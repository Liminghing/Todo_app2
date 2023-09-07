package com.todoapp.todo_app


import android.app.Dialog
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.todoapp.todo_app.public_object.Companion.ItemList
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class MyAdapter(private val context: Context, val itemList: ArrayList<MyData>) :
    RecyclerView.Adapter<MyAdapter.BoardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].todo_text

        holder.deleteButton.setOnClickListener {
            removeTask(position)
            val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
            val Edit=preferences.edit()
            val gson = Gson()
            val json = gson.toJson(ItemList)
            Edit.putString("ItemList", json)
            Edit.apply()
            save_data(json)
            notifyDataSetChanged()
            update_widget()
        }
        holder.editButton.setOnClickListener {
            var custom_dialog=context?.let{custom_dialog_2(it)}
            custom_dialog?.window?.setGravity(Gravity.BOTTOM)
            custom_dialog?.show()
            custom_dialog?.cancel_bt_2?.setOnClickListener {
                custom_dialog?.dismiss()
            }
            custom_dialog?.edit_bt_2?.setOnClickListener {
                var tx=custom_dialog?.editText_2?.text.toString()
                if (tx.length == 0 ) {
                    //공백일 때 처리할 내용
                    Toast.makeText(context,"내용이 없습니다",Toast.LENGTH_SHORT).show()
                } else {
                    //공백이 아닐 때 처리할 내용
                    ItemList[position].todo_text=tx
                }
                val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
                val Edit=preferences.edit()
                val gson = Gson()
                val json = gson.toJson(ItemList)
                Edit.putString("ItemList", json)
                Edit.apply()
                save_data(json)
                notifyDataSetChanged()
                custom_dialog?.dismiss()
                update_widget()
            }
        }
        when(itemList[position].item_check){
            0->{
                holder.check_view.setImageResource(R.drawable.circle_off)
            }
            1->{
                holder.check_view.setImageResource(R.drawable.circle_on)
            }
        }
        holder.check_view.setOnClickListener {
            when(itemList[position].item_check){
                0->{
                    holder.check_view.setImageResource(R.drawable.circle_on)
                    itemList[position].item_check=1
                }
                1->{
                    holder.check_view.setImageResource(R.drawable.circle_off)
                    itemList[position].item_check=0
                }
            }
        }


    }
    fun save_data(list_string:String){
        var now = LocalDate.now()
        var Strnow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        var index:Int?= public_object.ItemlistList.indexOfFirst { it.date == Strnow }
        if(index==-1){
            public_object.ItemlistList.add(MyListData(list_string,Strnow))
        }else{
            public_object.ItemlistList[index!!]=MyListData(list_string,Strnow)
        }
        val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
        val Edit=preferences.edit()
        val gson = Gson()
        val json = gson.toJson(public_object.ItemlistList)
        Edit.putString("ItemlistList", json)
        Edit.apply()
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }

    fun removeTask(position: Int) {
        ItemList.removeAt(position)
    }

    fun update_widget(){
        val appWidgetManager = AppWidgetManager.getInstance(context)

        val appWidgetIds_2 = appWidgetManager.getAppWidgetIds(
            ComponentName(
                context,
                widget_2::class.java
            )
        )
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds_2, R.id.widget_listview)
    }

    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.todo_item)
        val check_view = itemView.findViewById<ImageView>(R.id.imageView)
        val editButton = itemView.findViewById<ImageView>(R.id.edit_bt)
        val deleteButton = itemView.findViewById<ImageView>(R.id.delete_bt)
    }

}