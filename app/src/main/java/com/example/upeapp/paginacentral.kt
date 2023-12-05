package com.example.upeapp

import androidx.drawerlayout.widget.DrawerLayout
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView

class paginacentral : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paginacentral)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // Configurar o ActionBarDrawerToggle
        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Configurar a Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""

        // Habilitar o botão Up na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Configurar o listener do NavigationView
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home, R.id.contact, R.id.gallery, R.id.about, R.id.login, R.id.share, R.id.rate_us -> {
                    Toast.makeText(this@paginacentral, "Item selecionado: ${item.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
