package com.softinca.education.schoolapp.login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.Toolbar
import android.view.View
import com.softinca.education.schoolapp.estudiante.view.ListaEstudiantesActivity
import com.softinca.education.schoolapp.R
import com.softinca.education.schoolapp.helper.hideSoftKeyboard
import com.softinca.education.schoolapp.helper.showSimpleSnackbar
import com.softinca.education.schoolapp.login.MVP.LoginMVP
import com.softinca.education.schoolapp.login.model.entidad.UsuarioResponse
import com.softinca.education.schoolapp.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginMVP.view {

    private var presenter: LoginMVP.presenter? = null
    private lateinit var usuario: TextInputEditText
    private lateinit var clave: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = toolbar_login as Toolbar
        val btnIngresar = ingresar_login_button

        usuario = usuario_login_edittext
        clave = password_login_edittext
        presenter = LoginPresenter(this)


        toolbar.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        btnIngresar.apply {
            setOnClickListener {
                hideSoftKeyboard(this@LoginActivity)
                val user = usuario.text.toString().trim().toLowerCase()
                val password = clave.text.toString().trim().toLowerCase()
                presenter?.login(user, password)
            }
        }
    }

    override fun loginSuccess(usuario: UsuarioResponse) {
        showMensaje("Bienvenido ${usuario.usuario}")
        val intent   = Intent(this, ListaEstudiantesActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        overridePendingTransition(R.anim.left_in, R.anim.left_out)
        finish()
    }

    override fun showProgress() {
        login_progressbar.visibility = View.VISIBLE
        cortina_login_textview.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        login_progressbar.visibility = View.GONE
        cortina_login_textview.visibility = View.GONE
    }

    override fun showMensaje(message: String) {
        login_relativelayout.showSimpleSnackbar(message)
    }
}
