package com.alura.reto.ForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosPublicosTopico(
        @NotBlank Long id,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso,
        @NotBlank String titulo,
        @NotNull LocalDateTime fechaCreacion
) {

    public DatosPublicosTopico(Topico topico){
        this(topico.getId(), topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo(), topico.getFechaCreacion());
    }

}
