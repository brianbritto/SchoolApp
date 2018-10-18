package com.softinca.education.schoolapp.login.model.entidad

import com.google.gson.annotations.SerializedName

data class Usuario(

	@field:SerializedName("apellidos")
	val apellidos: String? = null,

	@field:SerializedName("clave")
	val clave: String? = null,

	@field:SerializedName("usuario")
	val usuario: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("nombres")
	val nombres: String? = null
)