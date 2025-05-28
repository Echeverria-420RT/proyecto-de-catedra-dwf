package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sv.edu.udb.controller.request.PlatoRequest;
import sv.edu.udb.controller.response.PlatoResponse;
import sv.edu.udb.repository.domain.Plato;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatoMapper {
    @Mapping(source = "categoria.nombre", target = "nombre_categoria")
    PlatoResponse toPlatoResponse(final Plato data);
    List<PlatoResponse> toPlatoResponseList(final List<Plato> list);
    @Mapping(target = "categoria.categoria_id", source = "categoria_id")
    Plato toPlato(final PlatoRequest request);
}