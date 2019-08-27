package com.princekr.android.navigationsample

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration

/**
 * A simple Activity demonstrating use of a NavHostFragment with a navigation drawer.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment)
                    as NavHostFragment? ?: return

        // set up action bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBar(navController, appBarConfiguration)

        setupNavigationMenu(navController)

        setupBottomMenu(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Toast.makeText(
                this@MainActivity, "Navigate to $dest",
                Toast.LENGTH_SHORT
            ).show()
            Log.d("NavigationActivity", "Navigated to $dest")
        }
    }

    private fun setupBottomMenu(navController: NavController) {

    }

    private fun setupNavigationMenu(navController: NavController) {

    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {

    }
}
