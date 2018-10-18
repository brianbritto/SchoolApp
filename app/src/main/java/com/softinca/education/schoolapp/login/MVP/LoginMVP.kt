package com.softinca.education.schoolapp.login.MVP

import com.softinca.education.schoolapp.login.model.entidad.UsuarioResponse
import io.reactivex.Flowable

interface LoginMVP {

    interface view{
        fun showProgress()
        fun hideProgress()
        fun showMensaje(message: String)
        fun loginSuccess(usuario: UsuarioResponse)
    }

    interface presenter{
        fun login(usuario: String, clave: String)
        fun destroy()
    }

    interface interactor{
        fun loginOnline(usuario: String, clave: String): Flowable<List<UsuarioResponse>>
    }
}