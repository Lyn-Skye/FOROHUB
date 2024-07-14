package com.alura.reto.ForoHub.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        String nombre,
        String email,
        String clave
) {
}
