package com.example.entregable2fragmentos

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.app.ShareCompat
import com.example.android.trackmysleepquality.database.Customers
import com.example.entregable2fragmentos.CustomerObject.retrofitService
import com.example.entregable2fragmentos.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//A partir de  esta variable me empieza a petar, pero si la quito directamente no hay datos obtenidos por la DB.
var datos_clientes: MutableList<Customers>? = null

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
        GlobalScope.launch {
            datos_clientes = CustomersDatabase.getDatabase(applicationContext).CustomersDao().getAll()
        }

        binding.fab.setOnClickListener {
            mandarPaginaWeb()
        }

        val botonPaginaWeb = findViewById<Button>(R.id.botonPaginaWeb)
        botonPaginaWeb.setOnClickListener {
            mandarPaginaWeb()
        }

        val boton2 = findViewById<Button>(R.id.button_2)
        boton2.setOnClickListener {
            mostrarDatosCliente()
        }



    }

    //val listResult = Propiedades.retrofitService.getProperties()

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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.help -> {
                (info.id)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }



    fun mostrarDatosCliente() {
        val listRecords = ArrayList<String>()
        val tvliterales = findViewById<TextView>(R.id.tvliterales)
        datos_clientes?.forEach {
            val instanceName = it.toString()
            listRecords.add(instanceName)
        }
        tvliterales.setText(datos_clientes.toString())

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

