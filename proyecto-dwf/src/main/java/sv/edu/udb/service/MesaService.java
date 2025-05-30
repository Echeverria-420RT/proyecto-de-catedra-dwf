package sv.edu.udb.service;

import sv.edu.udb.controller.request.MesaRequest;
import sv.edu.udb.controller.response.MesaResponse;

import java.util.List;

public interface MesaService {
    List<MesaResponse> findAll();
    MesaResponse findById(final Long id);
    MesaResponse save(final MesaRequest mesaRequest);
    MesaResponse update(final Long id, final MesaRequest mesaRequest);
    void delete(final Long id);
}
