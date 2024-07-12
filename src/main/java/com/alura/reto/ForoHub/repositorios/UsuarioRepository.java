package com.alura.reto.ForoHub.repositorios;

import com.alura.reto.ForoHub.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
