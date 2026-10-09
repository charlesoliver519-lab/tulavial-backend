package com.example

import kotlinx.serialization.json.Json

object UsuarioRepository {
    private val usuarios: List<Usuario> by lazy {
        val texto = object {}.javaClass.getResource("/usuarios.json")!!.readText()
        Json.decodeFromString<List<Usuario>>(texto)
    }

    fun validar(usuario: String, password: String): Usuario? =
        usuarios.firstOrNull { it.usuario == usuario && it.password == password }
}