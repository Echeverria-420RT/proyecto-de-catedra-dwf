package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sv.edu.udb.controller.request.DetallePedidoRequest;
import sv.edu.udb.controller.response.DetallePedidoResponse;
import sv.edu.udb.repository.domain.DetallePedido;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {
    @Mapping(source = "plato.nombre", target = "nombre_plato")
    DetallePedidoResponse toDetallePedidoResponse(final DetallePedido data);
    List<DetallePedidoResponse> toDetallePedidoResponseList(final List<DetallePedido> list);
    @Mapping(target = "pedido.pedido_id", source = "pedido_id")
    @Mapping(target = "plato.plato_id", source = "plato_id")
    DetallePedido toDetallePedido(final DetallePedidoRequest request);
}