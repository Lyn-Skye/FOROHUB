package com.alura.reto.ForoHub.controllers;


import com.alura.reto.ForoHub.foro.DatosActualizarTopico;
import com.alura.reto.ForoHub.foro.DatosPublicosTopico;
import com.alura.reto.ForoHub.foro.Topico;
import com.alura.reto.ForoHub.repositorios.TopicoRepository;
import com.alura.reto.ForoHub.repositorios.UsuarioRepository;
import com.alura.reto.ForoHub.usuario.DatosPublicosUsuario;
import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosPublicosTopico datosPublicosTopico, @RequestBody @Valid DatosPublicosUsuario datosPublicosUsuario) {
        System.out.println("Topico posteado correctamente");
        System.out.println(datosPublicosTopico);
        //topicoRepository.save(new Topico(datosPublicosTopico, datosPublicosUsuario));
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
