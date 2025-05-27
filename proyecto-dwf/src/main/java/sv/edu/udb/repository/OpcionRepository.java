package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.Opcion;

public interface OpcionRepository extends JpaRepository<Opcion, Long> {
}