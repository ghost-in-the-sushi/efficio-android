package org.ghostinthesuhi.android.efficio

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val drawerToggle: ActionBarDrawerToggle by lazy {
        object : ActionBarDrawerToggle(this, drawerLayout, 0, 0) {

        }
    }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        drawerLayout.addDrawerListener(drawerToggle)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        drawerLayout.closeDrawers()

        when (menuItem.itemId) {
            R.id.create_new_store -> navController.navigate(R.id.action_storeFragment_to_editItem)
            R.id.settings -> navController.navigate(R.id.action_storeFragment_to_settingsFragment)
        }

        return true
    }
}
