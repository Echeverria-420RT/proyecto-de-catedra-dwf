package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.MesaRequest;
import sv.edu.udb.controller.response.MesaResponse;
import sv.edu.udb.repository.domain.Mesa;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesaMapper {
    MesaResponse toMesaResponse(final Mesa data);
    List<MesaResponse> toMesaResponseList(final List<Mesa> list);
    Mesa toMesa(final MesaRequest request);
}