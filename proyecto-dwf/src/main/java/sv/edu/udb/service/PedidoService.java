package sv.edu.udb.service;

import sv.edu.udb.controller.request.PedidoRequest;
import sv.edu.udb.controller.response.PedidoResponse;

import java.util.List;

public interface PedidoService {
    List<PedidoResponse> findAll();
    PedidoResponse findById(Long id);
    PedidoResponse save(final PedidoRequest pedidoRequest);
    PedidoResponse update(final Long id, final PedidoRequest pedidoRequest);
    void delete(final Long id);
}
