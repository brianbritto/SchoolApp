package com.softinca.education.schoolapp.login.model.entidad

import com.google.gson.annotations.SerializedName

data class UsuarioResponse(
		@field:SerializedName("clave")
	val clave: Int? = null,
		@field:SerializedName("usuario")
	val usuario: String? = null,
		@field:SerializedName("id")
		val id: Int? = null
)
