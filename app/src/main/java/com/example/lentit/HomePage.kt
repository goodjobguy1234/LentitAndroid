package com.example.lentit

import android.os.Bundle
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lentit.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_home_page)

        // TODO
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
    //  val appBarConfiguration = AppBarConfiguration(
    //            setOf(
    //                R.id.navigation_home, R.id.navigation_chat, R.id.navigation_current, R.id.navigation_profile
    //            )
    //        )
    //        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
        actionBar?.hide()
        actionBar?.hideOffset
    }

    override fun onResume() {
        super.onResume()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

}