package com.alura.reto.ForoHub.repositorios;

import com.alura.reto.ForoHub.foro.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
