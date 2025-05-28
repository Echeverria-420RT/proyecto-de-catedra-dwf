package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.OpcionRequest;
import sv.edu.udb.controller.response.OpcionResponse;
import sv.edu.udb.repository.domain.Opcion;

import java.util.List;

@Mapper (componentModel = "spring")
public interface OpcionMapper {
    OpcionResponse toOpcionResponse(final Opcion data);
    List<OpcionResponse> toOpcionResponseList(final List<Opcion> list);
    Opcion toOpcion(final OpcionRequest request);
}