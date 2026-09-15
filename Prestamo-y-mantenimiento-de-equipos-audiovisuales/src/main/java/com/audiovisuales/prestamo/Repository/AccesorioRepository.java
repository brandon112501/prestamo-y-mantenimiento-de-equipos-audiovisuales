package com.audiovisuales.prestamo.Repository;

import com.audiovisuales.prestamo.Entity.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccesorioRepository extends JpaRepository<Accesorio, Long> {


    List<Accesorio> findByEquipoAsociadoId(Long equipoId);
}
