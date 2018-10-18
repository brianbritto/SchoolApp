package com.softinca.education.schoolapp.login.presenter

import android.util.Log
import com.softinca.education.schoolapp.helper.Constants
import com.softinca.education.schoolapp.login.MVP.LoginMVP
import com.softinca.education.schoolapp.login.model.LoginInteractor
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(val view: LoginMVP.view): LoginMVP.presenter {

    private val TAG = LoginInteractor::class.java.name
    private val compositeDisposable = CompositeDisposable()
    private val interactor = LoginInteractor()

    override fun login(usuario: String, clave: String) {
        view.showProgress()
        val disposable = interactor.loginOnline(usuario, clave).subscribe(
                { it ->
                    view.hideProgress()
                    val array = it.filter { it.usuario==usuario && it.clave==clave.toInt() }
                    if (array.isNotEmpty()){
                        Constants.idUsuario = array.get(0).id?:0
                        Log.i(TAG, "idUsuario -> ${Constants.idUsuario}")
                        view.loginSuccess(array.get(0))
                    }else{
                        view.showMensaje("Usuario y/o clave incorrecta.")
                    }
                },
                {
                    view.hideProgress()
                    view.showMensaje("Usuario y/o clave incorrecta.")
                    Log.i(TAG, "idUsuario -> ${it.message}")
                }
        )
        compositeDisposable.add(disposable)
    }

    override fun destroy() {
        if (!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}