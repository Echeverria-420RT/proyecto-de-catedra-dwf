package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetallePedidoRequest {
    @NotNull
    private Long pedido_id;
    @NotNull
    private Long plato_id;
    @NotNull
    @Min(1)
    private Integer cantidad;
    @NotNull
    @Positive
    private Double precio_unitario;
    private String opciones;
    private String notas;
}