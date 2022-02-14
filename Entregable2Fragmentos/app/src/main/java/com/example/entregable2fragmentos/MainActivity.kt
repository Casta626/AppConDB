package com.example.entregable2fragmentos

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ShareCompat
import com.example.entregable2fragmentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }

        //Aqui creamos y ponemos los literales para ponerlos en pantalla del cuarto fragmento.

        //val botonPaginaWeb = findViewById<Button>(R.id.botonPaginaWeb)
        //botonPaginaWeb.setOnClickListener { mandarPaginaWeb() }
        //val boton3 = findViewById<Button>(R.id.button_3)
        //boton3.setOnClickListener{obtenerDatos()}

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun obtenerDatos(){
        var literales = resources.getStringArray(R.array.literales)
        var tvliterales = findViewById<TextView>(R.id.tvliterales)
        tvliterales.setText(literales[0]+literales[1]+literales[2])
    }

    fun mandarPaginaWeb(){
        searchWeb("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
    }



    fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}

