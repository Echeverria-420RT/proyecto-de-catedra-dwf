package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants

public class MesaResponse {
    private Integer mesa_id;
    private Integer numero;
    private Integer capacidad;
    private String estado;
}