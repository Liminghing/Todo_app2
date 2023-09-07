package com.todoapp.todo_app


import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.todoapp.todo_app.public_object.Companion.ItemList
import com.todoapp.todo_app.public_object.Companion.ItemlistList
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class fragment_1 : Fragment()  {


    var recyclerview: RecyclerView?=null
    var AddButton: ImageView?=null
    var textView5:TextView?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.layout_fragment_1, container, false)
        //==================    뷰   ================//
        recyclerview=view.findViewById(R.id.recyclerview)
        AddButton=view.findViewById(R.id.add_item_button)
        textView5=view.findViewById(R.id.textView5)
        //==================    뷰   ================/
        set_text()


        AddButton?.setOnClickListener {
            var custom_dialog=context?.let{custom_dialog_1(it)}
            custom_dialog?.window?.setGravity(Gravity.BOTTOM)
            custom_dialog?.show()
            custom_dialog?.cancel_bt?.setOnClickListener {
                custom_dialog?.dismiss()
            }
            custom_dialog?.add_bt?.setOnClickListener {
                var tx=custom_dialog?.editText?.text.toString()
                if (tx.length == 0 ) {
                //공백일 때 처리할 내용
                    Toast.makeText(context,"내용이 없습니다",Toast.LENGTH_SHORT).show()
                } else {
                //공백이 아닐 때 처리할 내용
                    var now = LocalDate.now()
                    var Strnow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                    var list_size=ItemlistList.size
                    if (list_size!=0){
                        if (ItemlistList[list_size-1].date!=Strnow){
                            ItemList.clear()
                        }
                    }
                    ItemList.add(MyData(tx,0))
                    val preferences: SharedPreferences = requireContext().getSharedPreferences("prefs_name", 0)
                    val Edit=preferences.edit()
                    val gson = Gson()
                    val json = gson.toJson(ItemList)
                    Edit.putString("ItemList", json)
                    Edit.apply()
                    save_data(json)
                    Set_List()
                    set_text()
                    update_widget()
                }
                custom_dialog?.dismiss()
            }
        }
        Set_List()




        return view
    }
    fun set_text(){
        if (ItemList.size==0){
            textView5?.setText(R.string.add_todo_list)
        }
        else{
            textView5?.text=""
        }
    }

    fun save_data(list_string:String){
        var now = LocalDate.now()
        var Strnow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        var index:Int?= ItemlistList.indexOfFirst { it.date == Strnow }
        if(index==-1){
            ItemlistList.add(MyListData(list_string,Strnow))
        }else{
            ItemlistList[index!!]=MyListData(list_string,Strnow)
        }
        val preferences: SharedPreferences = requireContext().getSharedPreferences("prefs_name", 0)
        val Edit=preferences.edit()
        val gson = Gson()
        val json = gson.toJson(ItemlistList)
        Edit.putString("ItemlistList", json)
        Edit.apply()
    }

    fun Set_List(){
        val myAdapter= context?.let { MyAdapter(it,ItemList) }
        myAdapter?.notifyDataSetChanged()
        recyclerview?.adapter=myAdapter
        recyclerview?.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        val swipeHelper = SwipeHelper()  // ItemTouchHelper.Callback 구현 클래스
        val itemTouchHelper = ItemTouchHelper(swipeHelper)
        itemTouchHelper.attachToRecyclerView(recyclerview)
    }

    fun update_widget(){
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val appWidgetIds_2 = appWidgetManager.getAppWidgetIds(
            ComponentName(
                requireContext(),
                widget_2::class.java
            )
        )
        val widget = RemoteViews(context?.packageName, R.layout.widget_2)
        appWidgetManager.updateAppWidget(appWidgetIds_2,widget )
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds_2, R.id.widget_listview)
    }




}