package pe.edu.ulima.pm.cineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import androidx.core.view.get

import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.cineapp.fragments.CarteleraFragment
import pe.edu.ulima.pm.cineapp.fragments.NosotrosFragment

class ListadoPeliculasActivity : AppCompatActivity() {
    private lateinit var mDlaListaPeliculas : DrawerLayout
    private lateinit var mNviListaPeliculas : NavigationView

    private var toolbar : Toolbar? = null


    private val fragmentCartelera = CarteleraFragment()
    private val fragmentNosotros = NosotrosFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_peliculas)

        mDlaListaPeliculas = findViewById(R.id.dlaListaPeliculas)
        mNviListaPeliculas = findViewById(R.id.nviListaPeliculas)

        val nameUser="${intent.getStringExtra("nameUser")}".replaceFirstChar {it.uppercase() }
        val header : View = mNviListaPeliculas.getHeaderView(0)
        val eteNombre : TextView = header.findViewById(R.id.eteNombre)
        eteNombre.text = nameUser

        mNviListaPeliculas.setNavigationItemSelectedListener {
            it.isChecked=true

            val ft = supportFragmentManager.beginTransaction()


            when(it.itemId) {
                R.id.menCartelera ->{
                    mostrarFragmentCartelera(ft)
                }
                R.id.menNosotros -> mostrarFragmentNosotros(ft)
            }
8

            ft.addToBackStack(null)

            ft.commit()

            mDlaListaPeliculas.closeDrawers()
            true
        }


        // Aquí se ubica el fragment a mostrar por defecto
        val ft = supportFragmentManager.beginTransaction()
        val add = ft.add(R.id.fcvEleccion, fragmentCartelera)
        toolbar = findViewById(R.id.toolbar)
        toolbar!!.title = "Hola $nameUser"
        ft.commit()

        // Configurando toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //Se deja checkeado el primer item de la lista de navegación
        mNviListaPeliculas.menu[0].isChecked = true

    }

    private fun mostrarFragmentNosotros(ft: FragmentTransaction) {
        val argumentos = Bundle()
        argumentos.putString("nombre", "Hola ${intent.getStringExtra("nameUser")}")
        fragmentNosotros.arguments = argumentos
        ft.replace(R.id.fcvEleccion, fragmentNosotros)
        toolbar = findViewById(R.id.toolbar)
        toolbar!!.title = "¿Quiénes somos?"
    }

    fun mostrarFragmentCartelera(ft: FragmentTransaction) {
        ft.replace(R.id.fcvEleccion, fragmentCartelera)
        toolbar = findViewById(R.id.toolbar)
        toolbar!!.title = "Hola " + "${intent.getStringExtra("nameUser")}"
    }

}