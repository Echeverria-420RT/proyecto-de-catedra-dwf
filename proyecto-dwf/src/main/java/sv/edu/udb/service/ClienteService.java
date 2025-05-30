package sv.edu.udb.service;

import sv.edu.udb.controller.request.ClienteRequest;
import sv.edu.udb.controller.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> findAll();
    ClienteResponse findById(final Long id);
    ClienteResponse save(final ClienteRequest clienteRequest);
    ClienteResponse update(final Long id, final ClienteRequest clienteRequest);
    void delete(final Long id);
}