package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRep extends JpaRepository<Usuario,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_especialidad (id_usuario, id_especialidad) VALUES (:idUsuario, :idEspecialidad)", nativeQuery = true)
    void asignarEspecialidad(@Param("idUsuario") Long idUsuario, @Param("idEspecialidad") Long idEspecialidad);


    @Query(value = "SELECT e.descripcion " +
            "FROM usuario u " +
            "JOIN usuario_especialidad ue ON u.id_usuario = ue.id_usuario " +
            "JOIN especialidad e ON ue.id_especialidad = e.id_especialidad " +
            "WHERE u.id_usuario = :id", nativeQuery = true)
    List<String> findEspecialidadesByUsuarioId(@Param("id") Long idUsuario);



}
