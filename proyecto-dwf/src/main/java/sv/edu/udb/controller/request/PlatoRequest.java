package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Positive;
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
public class PlatoRequest {
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotNull
    @Positive
    private Double precio;
    @NotNull
    private Long categoria_id;
    private Boolean disponible;
}