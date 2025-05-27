package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants
public class PlatoResponse {
    private Integer plato_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
    private String nombre_categoria;
}