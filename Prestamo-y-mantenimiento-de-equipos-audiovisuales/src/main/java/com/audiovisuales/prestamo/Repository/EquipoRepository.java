package com.audiovisuales.prestamo.Repository;

import com.audiovisuales.prestamo.Entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByEstadoAndTipo(String estado, String tipo);
}