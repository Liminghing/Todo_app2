package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class fragment_3 : Fragment() {
    var tx1: TextView?=null
    var tx2: TextView?=null
    var tx3: TextView?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.layout_fragment_3, container, false)
        //==================    뷰   ================//

        tx1=view.findViewById(R.id.textView_setting_1)
        tx2=view.findViewById(R.id.textView_setting_3)
        //==================    뷰   ================//
        tx1?.setOnClickListener {
            var custom_dialog=context?.let{custom_dialog_3(it)}
            custom_dialog?.window?.setGravity(Gravity.BOTTOM)
            custom_dialog?.show()
            custom_dialog?.cancel_bt_3?.setOnClickListener {
                custom_dialog?.dismiss()
            }
            custom_dialog?.save_bt_3?.setOnClickListener {
                custom_dialog?.dismiss()
            }
        }
        tx2?.setOnClickListener {

        }



        return view
    }

}