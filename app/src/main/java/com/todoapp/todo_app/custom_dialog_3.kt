package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.NumberPicker
import android.widget.TextView
import com.todoapp.todo_app.public_object.Companion.language
import java.util.Locale


class custom_dialog_3 (context: Context): Dialog(context) {
    var cancel_bt_3: TextView?=null
    var save_bt_3: TextView?=null
    var numberPicker:NumberPicker?=null
    var language_list= arrayListOf("English","한국어")
    var convertlist=language_list.map { it }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_3)
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(window?.attributes)

        cancel_bt_3=findViewById(R.id.cancel_bt_3)
        save_bt_3=findViewById(R.id.save_bt_3)
        cancel_bt_3?.setText(R.string.CANCEL)
        save_bt_3?.setText(R.string.SAVE)
        numberPicker=findViewById(R.id.numberPicker)
        numberPicker!!.minValue=0
        numberPicker!!.maxValue=convertlist.size-1
        numberPicker!!.wrapSelectorWheel=true
        numberPicker!!.displayedValues=convertlist.toTypedArray()
        numberPicker!!.setOnValueChangedListener { picker, oldVal, newVal ->
            language=language_list[newVal]
            if (language=="한국어") {

                val config = Configuration()
                val locale=Locale("ko")
                config.setLocale(locale)
                context?.getResources()?.updateConfiguration(config, context?.getResources()?.getDisplayMetrics())
                cancel_bt_3?.setText("취소")
                save_bt_3?.setText("저장")

            }else if (language=="English"){
                val config = Configuration()
                val locale=Locale("us")
                config.setLocale(locale)
                context?.getResources()?.updateConfiguration(config, context?.getResources()?.getDisplayMetrics())
                cancel_bt_3?.setText("CANCEL")
                save_bt_3?.setText("SAVE")


            }else{

            }
            save_data()
        }
        layoutParams.width = public_object.dpi!!.toInt().dpToPx() // dpToPx()는 dp 값을 픽셀로 변환하는 확장 함수입니다.
        window?.attributes = layoutParams
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


    }
    fun Int.dpToPx(): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }

    fun save_data(){
        val preferences: SharedPreferences = context.getSharedPreferences("prefs_name", 0)
        val Edit=preferences.edit()
        Edit.putString("language", language)
        Edit.apply()

    }
}