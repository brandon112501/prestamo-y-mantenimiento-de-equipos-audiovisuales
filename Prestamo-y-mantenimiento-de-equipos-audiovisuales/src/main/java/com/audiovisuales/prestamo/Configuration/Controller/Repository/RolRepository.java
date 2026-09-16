package com.audiovisuales.prestamo.Configuration.Controller.Repository;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombreRol(String nombreRol);
}

