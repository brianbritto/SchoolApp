package com.softinca.education.schoolapp.estudiante.MVP

import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import io.reactivex.Flowable

interface EstudiantesMVP {
    interface view{
        fun showProgress()
        fun hideProgress()
        fun showMensaje(message: String)
        fun showEstudiantes(lista: ArrayList<EstudianteResponse>)
    }

    interface presenter{
        fun getEstudiantes(idUsuario: Int)
        fun destroy()
    }

    interface interactor{
        fun getEstudiantesOnline(idUsuario: Int): Flowable<List<EstudianteResponse>>
    }
}