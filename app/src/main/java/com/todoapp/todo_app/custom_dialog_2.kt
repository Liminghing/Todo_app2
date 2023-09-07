package com.todoapp.todo_app

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


class custom_dialog_2 (context: Context): Dialog(context) {
    var editText_2: EditText?=null
    var cancel_bt_2: TextView?=null
    var edit_bt_2: TextView?=null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_2)
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(window?.attributes)

        editText_2=findViewById(R.id.editText_2)
        cancel_bt_2=findViewById(R.id.cancel_bt_2)
        edit_bt_2=findViewById(R.id.edit_bt_2)

        layoutParams.width = public_object.dpi!!.toInt().dpToPx() // dpToPx()는 dp 값을 픽셀로 변환하는 확장 함수입니다.
        window?.attributes = layoutParams
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        editText_2?.requestFocus()
        val mgr = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        editText_2?.postDelayed(Runnable {
            mgr.showSoftInput(editText_2, InputMethodManager.SHOW_IMPLICIT)
        }, 100)




    }
    fun Int.dpToPx(): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }
}