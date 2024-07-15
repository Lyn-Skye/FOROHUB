package com.alura.reto.ForoHub.topico;

import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime fechaCreacion;
    private String nombreCurso;

    public Topico(DatosPublicosTopico datosPublicosTopico) {
        this.mensaje= datosPublicosTopico.mensaje();
        this.nombreCurso = datosPublicosTopico.nombreCurso();
        this.titulo = datosPublicosTopico.titulo();
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


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.nombreCurso = datosRegistroTopico.nombreCurso();
    }

}
