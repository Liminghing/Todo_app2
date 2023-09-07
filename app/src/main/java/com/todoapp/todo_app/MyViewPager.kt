package com.todoapp.todo_app

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


class MyViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // 스와이프 동작을 막기 위해 항상 false를 반환합니다.
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // 스와이프 동작을 막기 위해 항상 false를 반환합니다.
        return false
    }
}