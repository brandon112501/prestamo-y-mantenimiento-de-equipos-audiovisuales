package com.audiovisuales.prestamo.Repository;

import com.audiovisuales.prestamo.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByModulo(String modulo);
}