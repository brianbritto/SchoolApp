package com.softinca.education.schoolapp.login.model.service

import com.softinca.education.schoolapp.helper.Constants
import com.softinca.education.schoolapp.login.model.entidad.UsuarioResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface LoginService {

    @GET(Constants.USUARIOS)
    fun login(): Flowable<List<UsuarioResponse>>

}