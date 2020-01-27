package com.example.navbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navbottom.profile.ProfileFragment
import com.example.navbottom.setting.SettingFragment
import com.example.navbottom.users.UsersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null

        when (item.itemId) {
            R.id.nav_chats -> selectedFragment = ProfileFragment()
            R.id.nav_users -> selectedFragment = UsersFragment()
            R.id.nav_groups -> selectedFragment = SettingFragment()
        }

        if (selectedFragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit()
        }

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ProfileFragment()).commit()
        }
    }



}
