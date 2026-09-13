package Repository;

import Entity.DetalleSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleSolicitudRepository extends JpaRepository<DetalleSolicitud, Long> {

    // Este método será clave para saber qué equipos específicos tiene una solicitud
    List<DetalleSolicitud> findBySolicitudId(Long solicitudId);
}
