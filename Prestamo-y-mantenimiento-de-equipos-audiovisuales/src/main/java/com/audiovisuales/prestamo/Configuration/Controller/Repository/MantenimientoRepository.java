package com.audiovisuales.prestamo.Configuration.Controller.Repository;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
}
