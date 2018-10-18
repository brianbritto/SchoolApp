package com.softinca.education.schoolapp.estudiante.presenter

import android.util.Log
import com.softinca.education.schoolapp.estudiante.MVP.EstudiantesMVP
import com.softinca.education.schoolapp.estudiante.model.entidad.EstudianteResponse
import com.softinca.education.schoolapp.estudiante.model.ListaEstudiantesInteractor
import io.reactivex.disposables.CompositeDisposable

class ListaEstudiantesPresenter(val view: EstudiantesMVP.view): EstudiantesMVP.presenter {
    override fun destroy() {

    }
    private val TAG = ListaEstudiantesPresenter::class.java.name
    private val compositeDisposable = CompositeDisposable()
    private val interactor = ListaEstudiantesInteractor()
    override fun getEstudiantes(idUsuario: Int) {
        val disposable = interactor.getEstudiantesOnline(idUsuario).subscribe(
                { it ->
                    view.hideProgress()
                    val array = it.filter { it.idUsuario == idUsuario }
                    Log.i(TAG, "array Estudiantes -> $array")
                    if (array.isNotEmpty()){
                        view.showEstudiantes(array as ArrayList<EstudianteResponse>)
                    }else{
                        view.showMensaje("Data de estudiantes en construcción.")
                    }
                },
                {
                    view.showMensaje("Data de estudiantes en construcción.")
                    Log.i(TAG, "error Estudiantes -> ${it.message}")
                }
        )
        compositeDisposable.add(disposable)
    }
}