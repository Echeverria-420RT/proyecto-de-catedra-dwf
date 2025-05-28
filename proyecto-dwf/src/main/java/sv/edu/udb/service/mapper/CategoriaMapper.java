package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.CategoriaRequest;
import sv.edu.udb.controller.response.CategoriaResponse;
import sv.edu.udb.repository.domain.Categoria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponse toCategoriaResponse(final Categoria data);
    List<CategoriaResponse> toCategoriaResponseList(final List<Categoria> list);
    Categoria toCategoria(final CategoriaRequest request);
}