package com.alura.reto.ForoHub.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="Id") //usa el parametro ID para las comparaciones entre usuarios
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email; //posiblemente habrá que agregarle @NotBlank y @Email
    private String clave;

    public Usuario(DatosPublicosUsuario datosPublicosUsuario) {
        this.id = datosPublicosUsuario.id();
        this.nombre = datosPublicosUsuario.nombre();
    }

    public Usuario(DatosRegistroUsuario datosRegistroUsuario){
        this.nombre = datosRegistroUsuario.nombre();
        this.email = datosRegistroUsuario.email();
        this.clave = datosRegistroUsuario.clave();
    }

    public void actualizarDatosUsuario(DatosActualizarUsuario datosActualizarUsuario) {
        if(datosActualizarUsuario.nombre()!=null){
            this.nombre = datosActualizarUsuario.nombre();
        }
        if(datosActualizarUsuario.email()!=null){
            this.email = datosActualizarUsuario.email();
        }
        if(datosActualizarUsuario.clave()!=null){
            this.clave = datosActualizarUsuario.clave();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
