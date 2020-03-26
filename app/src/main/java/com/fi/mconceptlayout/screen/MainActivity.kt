package com.fi.mconceptlayout.screen

import android.view.Menu
import androidx.fragment.app.Fragment
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.base.BaseActivity
import com.fi.mconceptlayout.screen.homeFragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var menuItem: Menu? = null

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun getToolbarResource(): Int = 0

    override fun getToolbarTitle(): String = ""

    override fun setToolbarActionButton(): Boolean = false

    override fun mainCode() {
        setMenuNavigation()
    }

    private fun setMenuNavigation() {
        bn_main.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navmenu_home -> openFragment(HomeFragment())
                R.id.navmenu_notification -> openFragment(NotificationFragment())
                R.id.navmenu_account -> openFragment(AccountFragment())
            }
            true
        }
        bn_main.selectedItemId = R.id.navmenu_home
        val badge = bn_main.getOrCreateBadge(R.id.navmenu_notification)
        badge.isVisible = true
        badge.number = 30
    }

    private fun openFragment(fragment: Fragment) {
        //supportActionBar?.subtitle = title
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.cl_container, fragment)
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_bottom_navigation, menu)
        menuItem = menu

        return true
    }
}