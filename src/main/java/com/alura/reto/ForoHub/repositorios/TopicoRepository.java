package com.alura.reto.ForoHub.repositorios;

import com.alura.reto.ForoHub.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {

}
