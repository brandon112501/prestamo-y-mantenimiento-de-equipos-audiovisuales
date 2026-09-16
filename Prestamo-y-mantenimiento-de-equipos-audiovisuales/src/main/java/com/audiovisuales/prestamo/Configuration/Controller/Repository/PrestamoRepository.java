package com.audiovisuales.prestamo.Configuration.Controller.Repository;


import com.audiovisuales.prestamo.Configuration.Controller.Entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
