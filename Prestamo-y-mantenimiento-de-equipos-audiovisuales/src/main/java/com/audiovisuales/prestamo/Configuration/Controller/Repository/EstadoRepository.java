package com.audiovisuales.prestamo.Configuration.Controller.Repository;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByModulo(String modulo);
}