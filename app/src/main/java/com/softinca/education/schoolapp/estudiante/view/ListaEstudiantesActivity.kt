package com.softinca.education.schoolapp.estudiante.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.softinca.education.schoolapp.R
import com.softinca.education.schoolapp.estudiante.MVP.EstudiantesMVP
import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import com.softinca.education.schoolapp.estudiante.presenter.ListaEstudiantesPresenter
import com.softinca.education.schoolapp.estudiante.view.adapter.EstudianteAdapter
import com.softinca.education.schoolapp.helper.Constants
import com.softinca.education.schoolapp.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_lista_estudiantes.*

class ListaEstudiantesActivity : AppCompatActivity(), EstudiantesMVP.view {

    private lateinit var recyclerview: RecyclerView
    private lateinit var mAdapter: EstudianteAdapter
    private var presenter: EstudiantesMVP.presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_estudiantes)

        val toolbar = toolbar_lista_estudiantes as Toolbar
        recyclerview = findViewById(R.id.lista_estudiantes_recyclerview)

        toolbar.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        mAdapter = EstudianteAdapter(this){}
        recyclerview.apply {
        layoutManager = LinearLayoutManager(this@ListaEstudiantesActivity)
        setHasFixedSize(true)
        setItemViewCacheSize(20)
        this.adapter = mAdapter
        }

        presenter = ListaEstudiantesPresenter(this)
        presenter?.getEstudiantes(Constants.idUsuario)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_estudiante, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId){
            R.id.action_cerrar_sesion -> {
                val intent   = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                overridePendingTransition(R.anim.right_in, R.anim.right_out)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    override fun showEstudiantes(lista: ArrayList<EstudianteResponse>) {
        mAdapter.setList(lista)
    }

    override fun hideProgress() {
        lista_estudiantes_progressbar.visibility = View.GONE
    }

    override fun showMensaje(message: String) {

    }

    override fun showProgress() {
        lista_estudiantes_progressbar.visibility = View.VISIBLE
    }
}
