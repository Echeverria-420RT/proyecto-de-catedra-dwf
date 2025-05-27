package sv.edu.udb.repository.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoria_id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column
    private String descripcion;
}
