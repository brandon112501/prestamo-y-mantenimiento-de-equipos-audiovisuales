package com.audiovisuales.prestamo.Configuration.Controller.Repository;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByEstadoAndTipo(String estado, String tipo);
}