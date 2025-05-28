package sv.edu.udb.service;

import sv.edu.udb.controller.request.OpcionRequest;
import sv.edu.udb.controller.response.OpcionResponse;

import java.util.List;

public interface OpcionService {
    List<OpcionResponse> findAll();
    OpcionResponse findById(final Long id);
    OpcionResponse save(final OpcionRequest opcionRequest);
    OpcionResponse update(final Long id, final OpcionRequest opcionRequest);
    void delete(final Long id);
}
