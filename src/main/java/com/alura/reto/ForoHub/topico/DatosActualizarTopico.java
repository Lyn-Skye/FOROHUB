package com.alura.reto.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}