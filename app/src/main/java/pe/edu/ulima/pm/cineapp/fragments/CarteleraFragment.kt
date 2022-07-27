package pe.edu.ulima.pm.cineapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.*

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cineapp.GestorPeliculas
import pe.edu.ulima.pm.cineapp.Pelicula
import pe.edu.ulima.pm.cineapp.R
import pe.edu.ulima.pm.cineapp.adapters.ListadoPeliculasAdapter

class CarteleraFragment : Fragment() {
    private lateinit var mRviPeliculas : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartelera, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_navegacion, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPeliculas = view.findViewById(R.id.rviCartelera)

        val listaPlanetas : List<Pelicula> = GestorPeliculas().obtenerPeliculas()
        val adapter = ListadoPeliculasAdapter(listaPlanetas) {
            Log.i("PeliculasFragment","Se hizo click en la pelicula " + it.nombre)

            val argumentos = Bundle()
            argumentos.putString("titulo",it.nombre)
            argumentos.putInt("imagen", it.img)
            argumentos.putString("descripcion", it.resena)

            val peliculaFragment = PeliculaFragmment()
            peliculaFragment.arguments = argumentos

            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fcvEleccion, peliculaFragment)
            ft.addToBackStack(null)
            ft.commit()

        }
        mRviPeliculas.adapter = adapter
    }
}