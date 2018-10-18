package com.softinca.education.schoolapp.estudiante.model.service

import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import com.softinca.education.schoolapp.helper.Constants
import io.reactivex.Flowable
import retrofit2.http.GET

interface EstudianteService {

    @GET(Constants.ESTUDIANTES)
    fun getEstudiantes(): Flowable<List<EstudianteResponse>>

}