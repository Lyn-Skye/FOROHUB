package com.alura.reto.ForoHub.controllers;

import com.alura.reto.ForoHub.repositorios.UsuarioRepository;
import com.alura.reto.ForoHub.usuario.DatosActualizarUsuario;
import com.alura.reto.ForoHub.usuario.DatosPublicosUsuario;
import com.alura.reto.ForoHub.usuario.DatosRegistroUsuario;
import com.alura.reto.ForoHub.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired   //para evitar = new repository
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public void registrarUsuario (@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        System.out.println("El registro de usuario ha sido exitoso");
        System.out.println(datosRegistroUsuario);
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
    }

    @GetMapping
    public List<DatosPublicosUsuario> listarUsuarios(){
        return usuarioRepository.findAll().stream().map(DatosPublicosUsuario::new).toList();
    }

    @PutMapping
    @Transactional //Requiere el transaccitional porque noe stamos guardando los cambios directamente en la DB con .save como en registrar topico
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatosUsuario(datosActualizarUsuario);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
    }
}
