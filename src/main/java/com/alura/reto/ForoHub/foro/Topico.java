package com.alura.reto.ForoHub.foro;

import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="Id") //usa el parametro ID para las comparaciones entre topicos
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    @ManyToOne
    private Usuario usuario;

    public Topico(DatosPublicosTopico datosPublicosTopico) {
        this.
    }
//    private String status;
//    private Curso curso;
//    private Respuesta respuesta;
}
