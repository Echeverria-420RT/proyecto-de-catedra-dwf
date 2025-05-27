package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.sql.Timestamp;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants

public class PedidoResponse {
    private Integer pedido_id;
    private String nombre_cliente;
    private Integer numero_mesa;
    private Timestamp fechaHora;
    private String estado;
    private Double total;
}
