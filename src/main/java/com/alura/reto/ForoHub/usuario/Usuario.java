package com.alura.reto.ForoHub.usuario;

import jakarta.persistence.*;
import com.alura.reto.ForoHub.foro.Topico;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="Id") //usa el parametro ID para las comparaciones entre usuarios
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    @OneToMany//(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Topico topico;
//    private Perfil perfil;
}
