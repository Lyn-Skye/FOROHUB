package com.alura.reto.ForoHub.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosPublicosUsuario(
        @NotBlank Long id,
        @NotBlank String nombre
) {
    public DatosPublicosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre());
    }

}
