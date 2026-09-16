package com.audiovisuales.prestamo.Repository;

import com.audiovisuales.prestamo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}