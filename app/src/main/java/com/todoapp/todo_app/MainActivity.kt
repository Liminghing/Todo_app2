package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.todoapp.todo_app.public_object.Companion.ItemList
import com.todoapp.todo_app.public_object.Companion.app_first_run
import com.todoapp.todo_app.public_object.Companion.device_Width
import com.todoapp.todo_app.public_object.Companion.dpi
import com.todoapp.todo_app.public_object.Companion.language
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity(){
    var Myviewpager : com.todoapp.todo_app.MyViewPager?=null
    var tabLayout: TabLayout?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getScreenSize()
        load_data()



        // 어댑터 초기화
        Myviewpager=findViewById(R.id.Myviewpager)
        tabLayout=findViewById(R.id.tabLayout)
        var adapter = com.todoapp.todo_app.PagerAdapter(supportFragmentManager)
        adapter.addFragment(com.todoapp.todo_app.fragment_1(),"")
        adapter.addFragment(com.todoapp.todo_app.fragment_2(),"")
        adapter.addFragment(com.todoapp.todo_app.fragment_3(),"")

        Myviewpager?.adapter=adapter
        tabLayout?.setupWithViewPager(Myviewpager)
        tabLayout?.getTabAt(0)?.setIcon(R.drawable.home_stroke)
        tabLayout?.getTabAt(1)?.setIcon(R.drawable.calender_line)
        tabLayout?.getTabAt(2)?.setIcon(R.drawable.setting_line)

        Myviewpager?.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0->{

                        tabLayout?.getTabAt(0)?.setIcon(R.drawable.home_stroke)
                        tabLayout?.getTabAt(1)?.setIcon(R.drawable.calender_line)
                        tabLayout?.getTabAt(2)?.setIcon(R.drawable.setting_line)
                        val secondFragment = adapter.getItem(position) as com.todoapp.todo_app.fragment_1
                        secondFragment.set_text()
                        update_widget()
                    }
                    1->{
                        tabLayout?.getTabAt(0)?.setIcon(R.drawable.home_line)
                        tabLayout?.getTabAt(1)?.setIcon(R.drawable.calender_stroke)
                        tabLayout?.getTabAt(2)?.setIcon(R.drawable.setting_line)
                        val secondFragment = adapter.getItem(position) as com.todoapp.todo_app.fragment_2
                        secondFragment.Set_List()

                        update_widget()
                    }
                    2->{
                        tabLayout?.getTabAt(0)?.setIcon(R.drawable.home_line)
                        tabLayout?.getTabAt(1)?.setIcon(R.drawable.calender_line)
                        tabLayout?.getTabAt(2)?.setIcon(R.drawable.setting_stroke)
                        update_widget()
                    }
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }
    fun getScreenSize(){
        var display=this.applicationContext?.resources?.displayMetrics
        device_Width=display?.widthPixels!!
        dpi=device_Width/((this.resources.displayMetrics.densityDpi.toFloat())/ DisplayMetrics.DENSITY_DEFAULT)
    }
    fun set_language(){
        if (language=="한국어") {
            val config = Configuration()
            val locale= Locale("ko")
            config.setLocale(locale)
            this?.getResources()?.updateConfiguration(config, this?.getResources()?.getDisplayMetrics())

        }else if (language=="English"){
            val config = Configuration()
            val locale= Locale("us")
            config.setLocale(locale)
            this?.getResources()?.updateConfiguration(config, this?.getResources()?.getDisplayMetrics())

        }else{

        }
    }
    fun load_data(){
        val preferences =this.getSharedPreferences("prefs_name", 0)
        app_first_run= preferences?.getInt("app_first_run", 0)!!
        language=preferences?.getString("language", "English")!!
        set_language()
        val json = preferences?.getString("ItemlistList", null)
        if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<ArrayList<com.todoapp.todo_app.MyListData>>() {}.type
            com.todoapp.todo_app.public_object.Companion.ItemlistList = gson.fromJson<ArrayList<com.todoapp.todo_app.MyListData>>(json, type)
        }
        var i=0
        var now = LocalDate.now()
        var Strnow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        var index:Int?= com.todoapp.todo_app.public_object.Companion.ItemlistList.indexOfFirst { it.date == Strnow }
        if(index!=-1){
            var list_tx= com.todoapp.todo_app.public_object.Companion.ItemlistList[index!!].list_gson
            var gson = Gson()
            var type = object : TypeToken<ArrayList<com.todoapp.todo_app.MyData>>() {}.type
            ItemList=gson.fromJson<ArrayList<com.todoapp.todo_app.MyData>>(list_tx, type)
        }

        update_widget()
    }
    fun update_widget(){
        val appWidgetManager = AppWidgetManager.getInstance(this)

        val appWidgetIds_2 = appWidgetManager.getAppWidgetIds(
            ComponentName(
                this,
                com.todoapp.todo_app.widget_2::class.java
            )
        )
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds_2,
            R.id.widget_listview
        )
    }


}