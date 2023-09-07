package com.todoapp.todo_app

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.widget.RemoteViews
import android.widget.Toast

/**
 * Implementation of App Widget functionality.
 */
class widget_2 : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach {

            val serviceIntent = Intent(context, MyRemoteViewsService::class.java)
            val widget = RemoteViews(context.packageName, R.layout.widget_2)
            widget.setRemoteAdapter(R.id.widget_listview, serviceIntent)
            appWidgetManager.updateAppWidget(appWidgetIds, widget)

        }
    }


}
