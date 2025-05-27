package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.PlatoOpcion;

public interface PlatoOpcionRepository extends JpaRepository<PlatoOpcion, Long> {
}