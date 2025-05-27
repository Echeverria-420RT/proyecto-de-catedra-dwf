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
@Table(name = "platos_opciones")
@IdClass(PlatoOpcion.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatoOpcion {
    @Id
    private Integer plato_id;

    @Id
    private Integer opcion_id;

    @ManyToOne
    @JoinColumn(name = "plato_id", insertable = false, updatable = false)
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "opcion_id", insertable = false, updatable = false)
    private Opcion opcion;
}