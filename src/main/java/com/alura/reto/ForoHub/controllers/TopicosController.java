package com.alura.reto.ForoHub.controllers;


import com.alura.reto.ForoHub.foro.DatosPublicosTopico;
import com.alura.reto.ForoHub.foro.Topico;
import com.alura.reto.ForoHub.repositorios.TopicoRepository;
import com.alura.reto.ForoHub.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicosController{
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarTopico(@RequestBody DatosPublicosTopico datosPublicosTopico){
        System.out.println("Topico posteado correctamente, funciona");
        System.out.println(datosPublicosTopico);
        topicoRepository.save(new Topico(datosPublicosTopico));
    }
}
