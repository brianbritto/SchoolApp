package com.softinca.education.schoolapp.login.model

import com.softinca.education.schoolapp.helper.getConexionRetrofit
import com.softinca.education.schoolapp.login.MVP.LoginMVP
import com.softinca.education.schoolapp.login.model.entidad.UsuarioResponse
import com.softinca.education.schoolapp.login.model.service.LoginService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginInteractor: LoginMVP.interactor {

    private val retrofit = getConexionRetrofit()
    private val service = retrofit.create(LoginService::class.java)

    override fun loginOnline(usuario: String, clave: String): Flowable<List<UsuarioResponse>> {
        return service.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}