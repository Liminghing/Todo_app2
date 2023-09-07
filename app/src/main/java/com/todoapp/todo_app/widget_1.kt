package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.widget.RemoteViews
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class widget_1 : AppWidgetProvider() {
    companion object{
        var this_month_fitst=0
        var this_month_last=0
        var day_list =arrayListOf<Int>()

        const val rg_1="rg_1"
        const val rg_6="rg_6"

        //2-n
        const val line2_1="line2_1"
        const val line2_2="line2_2"
        const val line2_3="line2_3"
        const val line2_4="line2_4"
        const val line2_5="line2_5"
        const val line2_6="line2_6"
        const val line2_7="line2_7"
        //3-n
        const val line3_1="line3_1"
        const val line3_2="line3_2"
        const val line3_3="line3_3"
        const val line3_4="line3_4"
        const val line3_5="line3_5"
        const val line3_6="line3_6"
        const val line3_7="line3_7"
        //4-n
        const val line4_1="line4_1"
        const val line4_2="line4_2"
        const val line4_3="line4_3"
        const val line4_4="line4_4"
        const val line4_5="line4_5"
        const val line4_6="line4_6"
        const val line4_7="line4_7"
        //5-n
        const val line5_1="line5_1"
        const val line5_2="line5_2"
        const val line5_3="line5_3"
        const val line5_4="line5_4"
        const val line5_5="line5_5"
        const val line5_6="line5_6"
        const val line5_7="line5_7"
        //6-n
        const val line6_1="line6_1"
        const val line6_2="line6_2"
        const val line6_3="line6_3"
        const val line6_4="line6_4"
        const val line6_5="line6_5"
        const val line6_6="line6_6"
        const val line6_7="line6_7"
        //7-n
        const val line7_1="line7_1"
        const val line7_2="line7_2"
        const val line7_3="line7_3"
        const val line7_4="line7_4"
        const val line7_5="line7_5"
        const val line7_6="line7_6"
        const val line7_7="line7_7"



        const val REQUEST_CODE_WIDGET=501
    }

    @SuppressLint("RemoteViewLayout")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach {

            val serviceIntent = Intent(context, MyRemoteViewsService::class.java)
            val widget = RemoteViews(context.packageName, R.layout.widget_1)
            widget.setRemoteAdapter(R.id.widget_listview_1, serviceIntent)
            chekc_date()
            //set_button_transperent(context)
            when(this_month_fitst){
                0->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                1->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                2->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                3->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                4->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                5->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                6->{
                    widget.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
            }
            when(this_month_last){
                27->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                28->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                29->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                30->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                31->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                32->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                33->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                34->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                35->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                36->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                37->{
                    widget.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line7_1,"setTextColor",Color.BLACK)
                    widget.setInt(R.id.line7_2,"setTextColor",Color.BLACK)
                }
            }
            widget.setOnClickPendingIntent(R.id.rg1,widget_1().getPendingSelfIntent(context,rg_1))
            widget.setOnClickPendingIntent(R.id.rg6,widget_1().getPendingSelfIntent(context,rg_6))



            //2-n
            widget.setOnClickPendingIntent(R.id.line2_1,widget_1().getPendingSelfIntent(context,line2_1))
            widget.setOnClickPendingIntent(R.id.line2_2,widget_1().getPendingSelfIntent(context,line2_2))
            widget.setOnClickPendingIntent(R.id.line2_3,widget_1().getPendingSelfIntent(context,line2_3))
            widget.setOnClickPendingIntent(R.id.line2_4,widget_1().getPendingSelfIntent(context,line2_4))
            widget.setOnClickPendingIntent(R.id.line2_5,widget_1().getPendingSelfIntent(context,line2_5))
            widget.setOnClickPendingIntent(R.id.line2_6,widget_1().getPendingSelfIntent(context,line2_6))
            widget.setOnClickPendingIntent(R.id.line2_7,widget_1().getPendingSelfIntent(context,line2_7))
            //3-n
            widget.setOnClickPendingIntent(R.id.line3_1,widget_1().getPendingSelfIntent(context,line3_1))
            widget.setOnClickPendingIntent(R.id.line3_2,widget_1().getPendingSelfIntent(context,line3_2))
            widget.setOnClickPendingIntent(R.id.line3_3,widget_1().getPendingSelfIntent(context,line3_3))
            widget.setOnClickPendingIntent(R.id.line3_4,widget_1().getPendingSelfIntent(context,line3_4))
            widget.setOnClickPendingIntent(R.id.line3_5,widget_1().getPendingSelfIntent(context,line3_5))
            widget.setOnClickPendingIntent(R.id.line3_6,widget_1().getPendingSelfIntent(context,line3_6))
            widget.setOnClickPendingIntent(R.id.line3_7,widget_1().getPendingSelfIntent(context,line3_7))
            //4-n
            widget.setOnClickPendingIntent(R.id.line4_1,widget_1().getPendingSelfIntent(context,line4_1))
            widget.setOnClickPendingIntent(R.id.line4_2,widget_1().getPendingSelfIntent(context,line4_2))
            widget.setOnClickPendingIntent(R.id.line4_3,widget_1().getPendingSelfIntent(context,line4_3))
            widget.setOnClickPendingIntent(R.id.line4_4,widget_1().getPendingSelfIntent(context,line4_4))
            widget.setOnClickPendingIntent(R.id.line4_5,widget_1().getPendingSelfIntent(context,line4_5))
            widget.setOnClickPendingIntent(R.id.line4_6,widget_1().getPendingSelfIntent(context,line4_6))
            widget.setOnClickPendingIntent(R.id.line4_7,widget_1().getPendingSelfIntent(context,line4_7))
            //5-n
            widget.setOnClickPendingIntent(R.id.line5_1,widget_1().getPendingSelfIntent(context,line5_1))
            widget.setOnClickPendingIntent(R.id.line5_2,widget_1().getPendingSelfIntent(context,line5_2))
            widget.setOnClickPendingIntent(R.id.line5_3,widget_1().getPendingSelfIntent(context,line5_3))
            widget.setOnClickPendingIntent(R.id.line5_4,widget_1().getPendingSelfIntent(context,line5_4))
            widget.setOnClickPendingIntent(R.id.line5_5,widget_1().getPendingSelfIntent(context,line5_5))
            widget.setOnClickPendingIntent(R.id.line5_6,widget_1().getPendingSelfIntent(context,line5_6))
            widget.setOnClickPendingIntent(R.id.line5_7,widget_1().getPendingSelfIntent(context,line5_7))
            //6-n
            widget.setOnClickPendingIntent(R.id.line6_1,widget_1().getPendingSelfIntent(context,line6_1))
            widget.setOnClickPendingIntent(R.id.line6_2,widget_1().getPendingSelfIntent(context,line6_2))
            widget.setOnClickPendingIntent(R.id.line6_3,widget_1().getPendingSelfIntent(context,line6_3))
            widget.setOnClickPendingIntent(R.id.line6_4,widget_1().getPendingSelfIntent(context,line6_4))
            widget.setOnClickPendingIntent(R.id.line6_5,widget_1().getPendingSelfIntent(context,line6_5))
            widget.setOnClickPendingIntent(R.id.line6_6,widget_1().getPendingSelfIntent(context,line6_6))
            widget.setOnClickPendingIntent(R.id.line6_7,widget_1().getPendingSelfIntent(context,line6_7))
            //7-n
            widget.setOnClickPendingIntent(R.id.line7_1,widget_1().getPendingSelfIntent(context,line7_1))
            widget.setOnClickPendingIntent(R.id.line7_2,widget_1().getPendingSelfIntent(context,line7_2))
            widget.setOnClickPendingIntent(R.id.line7_3,widget_1().getPendingSelfIntent(context,line7_3))
            widget.setOnClickPendingIntent(R.id.line7_4,widget_1().getPendingSelfIntent(context,line7_4))
            widget.setOnClickPendingIntent(R.id.line7_5,widget_1().getPendingSelfIntent(context,line7_5))
            widget.setOnClickPendingIntent(R.id.line7_6,widget_1().getPendingSelfIntent(context,line7_6))
            widget.setOnClickPendingIntent(R.id.line7_7,widget_1().getPendingSelfIntent(context,line7_7))
            //2-n
            widget.setTextViewText(R.id.line2_1,"${day_list[0]}")
            widget.setTextViewText(R.id.line2_2,"${day_list[1]}")
            widget.setTextViewText(R.id.line2_3,"${day_list[2]}")
            widget.setTextViewText(R.id.line2_4,"${day_list[3]}")
            widget.setTextViewText(R.id.line2_5,"${day_list[4]}")
            widget.setTextViewText(R.id.line2_6,"${day_list[5]}")
            widget.setTextViewText(R.id.line2_7,"${day_list[6]}")
            //3-n
            widget.setTextViewText(R.id.line3_1,"${day_list[7]}")
            widget.setTextViewText(R.id.line3_2,"${day_list[8]}")
            widget.setTextViewText(R.id.line3_3,"${day_list[9]}")
            widget.setTextViewText(R.id.line3_4,"${day_list[10]}")
            widget.setTextViewText(R.id.line3_5,"${day_list[11]}")
            widget.setTextViewText(R.id.line3_6,"${day_list[12]}")
            widget.setTextViewText(R.id.line3_7,"${day_list[13]}")
            //4-n
            widget.setTextViewText(R.id.line4_1,"${day_list[14]}")
            widget.setTextViewText(R.id.line4_2,"${day_list[15]}")
            widget.setTextViewText(R.id.line4_3,"${day_list[16]}")
            widget.setTextViewText(R.id.line4_4,"${day_list[17]}")
            widget.setTextViewText(R.id.line4_5,"${day_list[18]}")
            widget.setTextViewText(R.id.line4_6,"${day_list[19]}")
            widget.setTextViewText(R.id.line4_7,"${day_list[20]}")
            //5-n
            widget.setTextViewText(R.id.line5_1,"${day_list[21]}")
            widget.setTextViewText(R.id.line5_2,"${day_list[22]}")
            widget.setTextViewText(R.id.line5_3,"${day_list[23]}")
            widget.setTextViewText(R.id.line5_4,"${day_list[24]}")
            widget.setTextViewText(R.id.line5_5,"${day_list[25]}")
            widget.setTextViewText(R.id.line5_6,"${day_list[26]}")
            widget.setTextViewText(R.id.line5_7,"${day_list[27]}")
            //6-n
            widget.setTextViewText(R.id.line6_1,"${day_list[28]}")
            widget.setTextViewText(R.id.line6_2,"${day_list[29]}")
            widget.setTextViewText(R.id.line6_3,"${day_list[30]}")
            widget.setTextViewText(R.id.line6_4,"${day_list[31]}")
            widget.setTextViewText(R.id.line6_5,"${day_list[32]}")
            widget.setTextViewText(R.id.line6_6,"${day_list[33]}")
            widget.setTextViewText(R.id.line6_7,"${day_list[34]}")
            //7-n
            widget.setTextViewText(R.id.line7_1,"${day_list[35]}")
            widget.setTextViewText(R.id.line7_2,"${day_list[36]}")
            widget.setTextViewText(R.id.line7_3,"${day_list[37]}")
            widget.setTextViewText(R.id.line7_4,"${day_list[38]}")
            widget.setTextViewText(R.id.line7_5,"${day_list[39]}")
            widget.setTextViewText(R.id.line7_6,"${day_list[40]}")
            widget.setTextViewText(R.id.line7_7,"${day_list[41]}")



            appWidgetManager.updateAppWidget(appWidgetIds, widget)




        }
    }

    @SuppressLint("ResourceType", "RemoteViewLayout")
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        context?.let{
            val view = RemoteViews(context.packageName, R.layout.widget_1)
            val appWidgetManger=AppWidgetManager.getInstance(it)
            val mWidget=ComponentName(it,widget_1::class.java)
            //set_button_transperent(context)
            when(this_month_fitst){
                0->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                1->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                2->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                3->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                4->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                5->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
                6->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line2_7,"setTextColor",Color.BLACK)
                }
            }
            when(this_month_last){
                27->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                28->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                29->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                30->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                31->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                32->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                33->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_6,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                34->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_7,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                35->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line7_1,"setTextColor",Color.LTGRAY)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                36->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line7_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line7_2,"setTextColor",Color.LTGRAY)
                }
                37->{
                    view.setInt(R.id.line5_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_2,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_3,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_4,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_5,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_6,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line6_7,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line7_1,"setTextColor",Color.BLACK)
                    view.setInt(R.id.line7_2,"setTextColor",Color.BLACK)
                }
            }
            view.setString(R.id.line7_2,"setText","${intent?.action}")
            when(intent?.action) {
                rg_1->{
                    view.setInt(R.id.line2_1,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_2,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_3,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_4,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_5,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_6,"setTextColor",Color.WHITE)
                    view.setInt(R.id.line2_7,"setTextColor",Color.WHITE)
                }
                rg_6->{}
                line2_1->{view.setInt(R.id.line2_1,"setTextColor",Color.WHITE)}
                line2_2->{view.setInt(R.id.line2_2,"setTextColor",Color.WHITE)}
                line2_3->{view.setInt(R.id.line2_3,"setTextColor",Color.WHITE)}
                line2_4->{view.setInt(R.id.line2_4,"setTextColor",Color.WHITE)}
                line2_5->{view.setInt(R.id.line2_5,"setTextColor",Color.WHITE)}
                line2_6->{view.setInt(R.id.line2_6,"setTextColor",Color.WHITE)}
                line2_7->{view.setInt(R.id.line2_7,"setTextColor",Color.WHITE)}
                line5_7->{view.setInt(R.id.line5_7,"setTextColor",Color.WHITE)}
                line6_1->{view.setInt(R.id.line6_1,"setTextColor",Color.WHITE)}
                line6_2->{view.setInt(R.id.line6_2,"setTextColor",Color.WHITE)}
                line6_3->{view.setInt(R.id.line6_3,"setTextColor",Color.WHITE)}
                line6_4->{view.setInt(R.id.line6_4,"setTextColor",Color.WHITE)}
                line6_5->{view.setInt(R.id.line6_5,"setTextColor",Color.WHITE)}
                line6_6->{view.setInt(R.id.line6_6,"setTextColor",Color.WHITE)}
                line6_7->{view.setInt(R.id.line6_7,"setTextColor",Color.WHITE)}
                line7_1->{view.setInt(R.id.line7_1,"setTextColor",Color.WHITE)}
                line7_2->{view.setInt(R.id.line7_2,"setTextColor",Color.WHITE)}
            }
        }
    }
    fun getPendingSelfIntent(context: Context,action:String):PendingIntent{
        val intent=Intent(context,widget_1::class.java)
        intent.action=action
        return PendingIntent.getBroadcast(
            context,
            REQUEST_CODE_WIDGET,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
    }
    fun chekc_date(){
        this_month_fitst=0
        this_month_last=0
        day_list.clear()
        day_list =arrayListOf<Int>(0,0,0,0,0,0,0, 0,0,0,0,0,0,0, 0,0,0,0,0,0,0, 0,0,0,0,0,0,0, 0,0,0,0,0,0,0, 0,0,0,0,0,0,0)
        val currentDate = LocalDate.now()
        val firstDayOfMonth = currentDate.withDayOfMonth(1)
        val date =firstDayOfMonth.dayOfWeek
        var first_day = 0
        if (date.value==7){
            first_day = 0
        }else{
            first_day = date.value
        }
        val lastDay = currentDate.withDayOfMonth(currentDate.lengthOfMonth()).dayOfMonth
        var i=1
        var q=first_day
        this_month_fitst=first_day
        this_month_last=lastDay+first_day
        while (i<=lastDay+first_day-1){
            day_list[q]=i
            q++
            i++
        }
        var k=1
        while(i<42){
            day_list[i]=k
            k++
            i++
        }
        val previousMonth = currentDate.minusMonths(1)
        val previousMonth_lastDay = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth()).dayOfMonth
        var t=first_day
        var r=0
        while (t>0){
            day_list[t-1]=previousMonth_lastDay-r
            r++
            t--
        }
    }
    //fun set_button_transperent(context: Context?) {
    //    val view = RemoteViews(context?.packageName, R.layout.widget_1)
    //    val appWidgetManger=AppWidgetManager.getInstance(context!!)
    //    val mWidget=ComponentName(context!!,widget_1::class.java)
    //    appWidgetManger.updateAppWidget(mWidget,view)
    //    //2-n
    //    view.setInt(R.id.line2_1,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_2,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_3,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_4,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_5,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_6,"setBackgroundColor",Color.TRANSPARENT)
    //    view.setInt(R.id.line2_7,"setBackgroundColor",Color.TRANSPARENT)
    //    appWidgetManger.updateAppWidget(mWidget,view)
    //}
}