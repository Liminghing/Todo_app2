package com.todoapp.todo_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(manager: FragmentManager): FragmentStatePagerAdapter(manager) {
    private val fragmentList=ArrayList<Fragment>()
    private val titleList=ArrayList<String>()
    override fun getCount(): Int =titleList.size
    override fun getItem(position: Int): Fragment =fragmentList[position]
    override fun getPageTitle(position: Int): CharSequence =titleList[position]
    fun addFragment(fragment: Fragment, title:String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

}