package com.softinca.education.schoolapp.estudiante.model.entidad

import com.google.gson.annotations.SerializedName

data class EstudianteResponse(

	@field:SerializedName("apellidos")
	val apellidos: String? = null,

	@field:SerializedName("grado")
	val grado: String? = null,

	@field:SerializedName("idUsuario")
	val idUsuario: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("edad")
	val edad: Int? = null,

	@field:SerializedName("fotoUrl")
	val fotoUrl: String? = null,

	@field:SerializedName("nombres")
	val nombres: String? = null
)