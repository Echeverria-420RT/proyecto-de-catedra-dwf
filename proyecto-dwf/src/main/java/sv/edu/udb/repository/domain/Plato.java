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
@Table(name = "platos")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plato_id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private Boolean disponible = true;
}