package com.codemobiles.myauthen.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codemobiles.myauthen.ChartFragment
import com.codemobiles.myauthen.JSONFragment
import com.codemobiles.myauthen.R
import kotlinx.android.synthetic.main.custom_tab.view.*

private val TAB_TITLES = arrayOf<String>(
    "JSON",
    "Chart"
)

private val TAB_ICONS = arrayOf<Int>(
    R.drawable.ic_tab_json,
    R.drawable.ic_tab_chart
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                JSONFragment()
            }
            else -> {
                ChartFragment()
            }
        }
    }

    // custom tabs
//    override fun getPageTitle(position: Int): CharSequence? {
//        return TAB_TITLES[position]
//    }

    override fun getCount(): Int {
        return TAB_TITLES.count()
    }

    // Custom Tabs
    fun getTabView(position: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.custom_tab, null).apply {
            icon_tab.setImageResource(TAB_ICONS[position])
            text_tab.text = TAB_TITLES[position]
        }
    }
}