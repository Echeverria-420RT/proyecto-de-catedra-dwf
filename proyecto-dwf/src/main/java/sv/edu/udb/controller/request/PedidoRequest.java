package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoRequest {
    @NotNull
    private Long cliente_id;
    @NotNull
    private Long mesa_id;
    @NotNull
    private String estado;
    @NotNull
    @Positive
    private Double total;
}