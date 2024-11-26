package com.fixfinder.fixfinderback.Services;
import com.fixfinder.fixfinderback.Models.TipoUsuario;
import com.fixfinder.fixfinderback.repositorio.TipoUsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRep tipoUsuarioRepository;

    public TipoUsuario guardarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public Optional<TipoUsuario> obtenerTipoUsuarioPorId(Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    public List<TipoUsuario> obtenerTodosTipoUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    public void eliminarTipoUsuario(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }

}
