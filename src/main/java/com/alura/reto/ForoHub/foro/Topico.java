package com.alura.reto.ForoHub.foro;

import com.alura.reto.ForoHub.usuario.DatosPublicosUsuario;
import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
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
    private String nombreCurso;
    private Long idUsuario;
    private String nombre;

    public Topico(DatosPublicosTopico datosPublicosTopico, DatosPublicosUsuario datosPublicosUsuario) {
        this.mensaje= datosPublicosTopico.mensaje();
        this.nombreCurso = datosPublicosTopico.nombreCurso();
        this.titulo = datosPublicosTopico.titulo();
        this.idUsuario = datosPublicosUsuario.id();
        this.nombre = datosPublicosUsuario.nombre();
    }

    public void actualizarDatosTopico(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje()!=null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreCurso()!=null){
            this.nombreCurso = datosActualizarTopico.nombreCurso();
        }
        if(datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
        }
    }
//    private String status;
//    private Curso curso;
//    private Respuesta respuesta;
}
