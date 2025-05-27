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
@Table(name = "opciones")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer opcion_id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "precio_adicional")
    private Double precioAdicional;
}
