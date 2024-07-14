package com.alura.reto.ForoHub.foro;

import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record DatosPublicosTopico(
        @NotBlank Long id,
        @NotBlank String mensaje,
        @NotBlank String nombreCurso,
        @NotBlank String titulo
        //falta incluir la fecha actual
) {

    public DatosPublicosTopico(Topico topico){
        this(topico.getId(), topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo());
    }

}
