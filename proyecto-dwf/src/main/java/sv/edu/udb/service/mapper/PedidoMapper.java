package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sv.edu.udb.controller.request.PedidoRequest;
import sv.edu.udb.controller.response.PedidoResponse;
import sv.edu.udb.repository.domain.Pedido;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    @Mapping(source = "cliente.nombre", target = "nombre_cliente")
    @Mapping(source = "mesa.numero", target = "numero_mesa")
    PedidoResponse toPedidoResponse(final Pedido data);

    List<PedidoResponse> toPedidoResponseList(final List<Pedido> list);

    @Mapping(target = "cliente.cliente_id", source = "cliente_id")
    @Mapping(target = "mesa.mesa_id", source = "mesa_id")
    Pedido toPedido(final PedidoRequest request);
}