package sv.edu.udb.service;

import sv.edu.udb.controller.request.PlatoRequest;
import sv.edu.udb.controller.response.PlatoResponse;

import java.util.List;

public interface PlatoService {
    List<PlatoResponse> findAll();
    PlatoResponse findById(final Long id);
    PlatoResponse save(final PlatoRequest platoRequest);
    PlatoResponse update(final Long id, final PlatoRequest platoRequest);
    void delete(final Long id);
}