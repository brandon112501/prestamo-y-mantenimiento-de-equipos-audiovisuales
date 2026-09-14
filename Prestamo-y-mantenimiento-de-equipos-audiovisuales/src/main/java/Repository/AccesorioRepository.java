package Repository;

import Entity.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccesorioRepository extends JpaRepository<Accesorio, Long> {


    List<Accesorio> findByEquipoId(Long equipoId);
}
