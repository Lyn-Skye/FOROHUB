package com.alura.reto.ForoHub.foro;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
