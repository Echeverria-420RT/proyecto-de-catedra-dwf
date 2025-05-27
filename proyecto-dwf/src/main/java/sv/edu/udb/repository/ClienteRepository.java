package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
