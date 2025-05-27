package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
}