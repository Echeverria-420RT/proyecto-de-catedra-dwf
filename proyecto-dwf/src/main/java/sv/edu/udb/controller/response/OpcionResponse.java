package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants
public class OpcionResponse {
    private Integer opcion_id;
    private String nombre;
    private Double precioAdicional;
}