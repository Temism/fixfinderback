package com.fixfinder.fixfinderback.Services;

import com.fixfinder.fixfinderback.Models.Especialidad;
import com.fixfinder.fixfinderback.Models.Usuario;
import com.fixfinder.fixfinderback.repositorio.EspecialidadRep;
import com.fixfinder.fixfinderback.repositorio.UsuarioRep;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRep usuarioRepository;

    @Autowired
    private EspecialidadRep especialidaRep;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


    public List<String> obtenerEspecialidadesPorUsuario(Long idUsuario) {
        return usuarioRepository.findEspecialidadesByUsuarioId(idUsuario);
    }

    @Transactional
    public void asignarEspecialidades(Long idUsuario, List<Long> especialidadIds) {
        for (Long idEspecialidad : especialidadIds) {
            usuarioRepository.asignarEspecialidad(idUsuario, idEspecialidad);
        }
    }

}
