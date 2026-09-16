package com.audiovisuales.prestamo.Repository;

import com.audiovisuales.prestamo.Entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {


    List<Solicitud> findBySolicitanteId(Long solicitanteId);


    List<Solicitud> findByEstado(String estado);
}