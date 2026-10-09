package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.request.*


fun Application.configureRouting() {
    routing {
        get("/") { call.respondText("TulaVial API") }

        post("/login") {
            val req = call.receive<LoginRequest>()
            val u = UsuarioRepository.validar(req.usuario, req.password)
            if (u != null) {
                call.respond(LoginResponse(true, "Bienvenido", UsuarioDto(u.id, u.nombre, u.rol)))
            } else {
                call.respond(HttpStatusCode.Unauthorized, LoginResponse(false, "Credenciales incorrectas"))
            }
        }
    }
}