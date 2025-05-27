package sv.edu.udb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}