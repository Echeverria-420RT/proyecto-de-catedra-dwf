package sv.edu.udb.repository.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatoOpcionId implements Serializable {
    private Integer plato_id;
    private Integer opcion_id;
}
