package com.alura.reto.ForoHub.controllers;
import com.alura.reto.ForoHub.topico.DatosRegistroTopico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import com.alura.reto.ForoHub.topico.DatosActualizarTopico;
import com.alura.reto.ForoHub.topico.DatosPublicosTopico;
import com.alura.reto.ForoHub.topico.Topico;
import com.alura.reto.ForoHub.repositorios.TopicoRepository;
import com.alura.reto.ForoHub.repositorios.UsuarioRepository;
import com.alura.reto.ForoHub.usuario.DatosPublicosUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosPublicosTopico(topico));
    }

    @GetMapping
    public List<DatosPublicosTopico> listarTopicos(){
        return topicoRepository.findAll().stream().map(DatosPublicosTopico::new).toList();
    }

    /*    @GetMapping //Si se desea que use paginas
    public Page<DatosPublicosTopico> listarTopicos(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosPublicosTopico::new);
    }*/

    @PutMapping
    @Transactional //Requiere el transaccitional porque noe stamos guardando los cambios directamente en la Base de DAtos con .save como en registrar topico
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatosTopico(datosActualizarTopico);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void borrarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
