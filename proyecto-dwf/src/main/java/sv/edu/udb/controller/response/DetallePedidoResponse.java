package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants
public class DetallePedidoResponse {
    private Integer detalle_id;
    private String nombre_plato;
    private Integer cantidad;
    private Double precio_unitario;
    private String opciones;
    private String notas;
}