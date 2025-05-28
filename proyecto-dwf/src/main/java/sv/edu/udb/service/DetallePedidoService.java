package sv.edu.udb.service;

import sv.edu.udb.controller.request.DetallePedidoRequest;
import sv.edu.udb.controller.response.DetallePedidoResponse;

import java.util.List;

public interface DetallePedidoService {
    List<DetallePedidoResponse> findAll();
    DetallePedidoResponse findById(final Long id);
    DetallePedidoResponse save(final DetallePedidoRequest detallePedidoRequest);
    DetallePedidoResponse update(final Long id, final DetallePedidoRequest detallePedidoRequest);
    void delete(final Long id);
}
