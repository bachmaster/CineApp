package pe.edu.ulima.pm.cineapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import pe.edu.ulima.pm.cineapp.fragments.CarteleraFragment


class MainActivity : AppCompatActivity() {
    //Se crea una variabla de tipo TextInput
    var tietNameUser: TextInputEditText? = null

    //Se crea una variable de tipo button
    var btnLogin: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se captura el valor de tietNameUser
        tietNameUser = findViewById(R.id.tietNameUser)

        //Se captura el valor de btnLogin
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin!!.setOnClickListener{
            val intent= Intent()
            intent.setClass(this, ListadoPeliculasActivity::class.java)

            //Se crea una variable para almacenar el nombre del usuario
            val nameUser = Bundle()

            //nameUser.putString("nameUser",tietNameUser!!.text.toString())
            nameUser.putString("nameUser", tietNameUser!!.text.toString())
            intent.putExtras(nameUser)

            nameUser.putString("nombre", tietNameUser!!.text.toString())
            val fragmento = CarteleraFragment()
            fragmento.arguments = nameUser

            startActivity(intent)
        }


    }

}