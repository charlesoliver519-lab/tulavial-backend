package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: Int,
    val usuario: String,
    val password: String,
    val rol: String,
    val nombre: String
)

@Serializable
data class LoginRequest(val usuario: String, val password: String)

// No se devuelve la contraseña al cliente
@Serializable
data class UsuarioDto(val id: Int, val nombre: String, val rol: String)

@Serializable
data class LoginResponse(
    val exito: Boolean,
    val mensaje: String,
    val usuario: UsuarioDto? = null
)