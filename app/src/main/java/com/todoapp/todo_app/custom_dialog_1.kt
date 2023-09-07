package com.todoapp.todo_app

import android.app.Dialog
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.todoapp.todo_app.public_object.Companion.dpi


class custom_dialog_1(context: Context): Dialog(context){
    var editText:EditText?=null
    var cancel_bt:TextView?=null
    var add_bt:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_1)
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(window?.attributes)

        editText=findViewById(R.id.editText)
        cancel_bt=findViewById(R.id.cancel_bt)
        add_bt=findViewById(R.id.add_bt)
        layoutParams.width = dpi!!.toInt().dpToPx() // dpToPx()는 dp 값을 픽셀로 변환하는 확장 함수입니다.
        window?.attributes = layoutParams
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        editText?.requestFocus()
        val mgr = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        editText?.postDelayed(Runnable {
            mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
                                       }, 100)




    }
    fun Int.dpToPx(): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }
}