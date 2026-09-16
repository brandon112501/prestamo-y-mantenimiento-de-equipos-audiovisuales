package com.audiovisuales.prestamo.Configuration.Controller.Repository;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccesorioRepository extends JpaRepository<Accesorio, Long> {


    List<Accesorio> findByEquipoId(Long equipoId);
}
