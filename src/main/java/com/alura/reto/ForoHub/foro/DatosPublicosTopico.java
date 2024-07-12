package com.alura.reto.ForoHub.foro;

public record DatosPublicosTopico(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
