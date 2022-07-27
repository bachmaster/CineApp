package pe.edu.ulima.pm.cineapp.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pe.edu.ulima.pm.cineapp.R

class PeliculaFragmment : Fragment() {
    private var titulo: String? = null
    private var imagen: Int? = null
    private var descripcion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titulo = it.getString("titulo")
            imagen = it.getInt("imagen")
            descripcion = it.getString("descripcion")
        }
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_pelicula, container, false)
        val txtTitulo = v.findViewById<TextView>(R.id.txtPelicula)
        txtTitulo.text = titulo
        val imagenView = v.findViewById<ImageView>(R.id.imagenPelicula)
        imagenView.setImageResource(imagen!!)
        val txtTexto = v.findViewById<TextView>(R.id.txtTexto)
        txtTexto.text = descripcion
        val btn = v.findViewById<Button>(R.id.btnBack2)
        btn?.setOnClickListener {
            val ft = requireActivity().supportFragmentManager
            ft.popBackStack()
            (activity as AppCompatActivity).supportActionBar?.show()
        }
        return v
    }


}