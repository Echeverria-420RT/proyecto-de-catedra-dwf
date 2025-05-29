package sv.edu.udb.service;

import sv.edu.udb.controller.request.ClienteRequest;
import sv.edu.udb.controller.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> findAll();
    ClienteResponse findById(final Long id);
    ClienteResponse update(final ClienteRequest clienteRequest);
    ClienteResponse save(final Long id, final ClienteRequest clienteRequest);

    ClienteResponse save(ClienteRequest request);

    ClienteResponse update(Long id, ClienteRequest request);

    void delete(final Long id);
}