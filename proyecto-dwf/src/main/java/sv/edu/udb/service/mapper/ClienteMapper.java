package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sv.edu.udb.controller.request.ClienteRequest;
import sv.edu.udb.controller.response.ClienteResponse;
import sv.edu.udb.repository.domain.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mapping(expression = "java(cliente.getNombre() + \" \" + cliente.getApellido())", target = "nombre_completo")
    ClienteResponse toClienteResponse(final Cliente cliente);
    List<ClienteResponse> toClienteResponseList(final List<Cliente> list);
    Cliente toCliente(final ClienteRequest request);
}