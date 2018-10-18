package com.softinca.education.schoolapp.estudiante.model

import com.softinca.education.schoolapp.estudiante.MVP.EstudiantesMVP
import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import com.softinca.education.schoolapp.estudiante.model.service.EstudianteService
import com.softinca.education.schoolapp.helper.getConexionRetrofit
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListaEstudiantesInteractor: EstudiantesMVP.interactor {

    private val retrofit = getConexionRetrofit()
    private val service = retrofit.create(EstudianteService::class.java)

    override fun getEstudiantesOnline(idUsuario: Int): Flowable<List<EstudianteResponse>> {
        return service.getEstudiantes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}