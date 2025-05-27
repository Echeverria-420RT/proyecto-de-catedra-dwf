package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants

public class ClienteResponse {
    private Integer cliente_id;
    private String nombre_completo;
    private String email;
    private String telefono;
    private String direccion;
}
