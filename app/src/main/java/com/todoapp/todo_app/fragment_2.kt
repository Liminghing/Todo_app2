package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.todoapp.todo_app.public_object.Companion.ItemList
import com.todoapp.todo_app.public_object.Companion.ItemList_2
import com.todoapp.todo_app.public_object.Companion.ItemlistList
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


class fragment_2 : Fragment() {
    var calendarview: CalendarView?=null
    var recyclerview: RecyclerView?=null



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.layout_fragment_2, container, false)
        //==================    뷰   ================//
        calendarview=view.findViewById(R.id.MyCalender)
        recyclerview=view.findViewById(R.id.fr2_RecyclerView)
        //==================    뷰   ================//

        Set_List()
        set_calender_language()
        //var tx= Date(calendarview!!.date)
        //var df= SimpleDateFormat("yyyyMMdd")
        //var tt=df.format(tx)
        calendarview?.setOnDateChangeListener{view,year,month,dayOfMonth->
            var Month=0
            if (month>=1){
                Month=month+1
            }else{
                Month=1
            }
            val MONTH = String.format("%02d", Month.toInt())
            val msg:String = year.toString() + (MONTH).toString() + dayOfMonth.toString()
            var index:Int?= ItemlistList.indexOfFirst { it.date == msg }

            if(index!=-1){
                var list_tx= ItemlistList[index!!].list_gson
                var gson = Gson()
                var type = object : TypeToken<ArrayList<MyData>>() {}.type
                ItemList_2=gson.fromJson<ArrayList<MyData>>(list_tx, type)
            }else{
                ItemList_2.clear()
            }
            Set_List_2()
        }


        return view
    }
    fun set_calender_language(){

    }

    fun Set_List(){
        val myAdapter= context?.let { MyAdapter2(it, ItemList) }
        myAdapter?.notifyDataSetChanged()
        recyclerview?.adapter=myAdapter
        recyclerview?.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }
    fun Set_List_2(){
        val myAdapter= context?.let { MyAdapter2(it, ItemList_2) }
        myAdapter?.notifyDataSetChanged()
        recyclerview?.adapter=myAdapter
        recyclerview?.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }






}