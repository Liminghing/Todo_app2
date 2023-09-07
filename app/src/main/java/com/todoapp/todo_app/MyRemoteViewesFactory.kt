package com.todoapp.todo_app

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//MyRemoteViewsFactory

class MyRemoteViewsFactory(
    private val context: Context
) : RemoteViewsService.RemoteViewsFactory {

    private var data = listOf(1,2,3,4,5,6,7,8,9,10)
    var list=ArrayList<MyData>()
    var list_size=ArrayList<MyData>()
    override fun onCreate() {
    }

    override fun onDataSetChanged() {
        //data 가 바뀌었다는 호출을 받았을 때 실행되는 함수
        val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
        val json = preferences.getString("ItemList", null)
        val gson = Gson()
        val type = object : TypeToken<ArrayList<MyData>>() {}.type
        list_size=gson.fromJson<ArrayList<MyData>>(json, type)

    }

    override fun onDestroy() {}

    override fun getCount() = list_size.size

    @SuppressLint("RemoteViewLayout")
    override fun getViewAt(position: Int): RemoteViews {

        val listviewWidget = RemoteViews(context.packageName,com.todoapp.todo_app.R.layout.item_list_2)
        // ListView에 들어갈 item 뷰를 따로 생성해 줬습니다.
        val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
        val json = preferences.getString("ItemList", null)
        if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<ArrayList<MyData>>() {}.type
            list = gson.fromJson<ArrayList<MyData>>(json, type)
            var tx=list[position].todo_text
            listviewWidget.setTextViewText(com.todoapp.todo_app.R.id.textView, tx )
        }





        return listviewWidget
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun hasStableIds(): Boolean {
        return false
    }
}
