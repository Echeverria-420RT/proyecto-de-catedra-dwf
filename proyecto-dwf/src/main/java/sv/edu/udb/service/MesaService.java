package sv.edu.udb.service;

import sv.edu.udb.controller.request.MesaRequest;
import sv.edu.udb.controller.response.MesaResponse;

import java.util.List;

public interface MesaService {
    List<MesaResponse> findAll();
    MesaResponse findById(final Long id);
    MesaResponse update(final MesaRequest mesaRequest);
    MesaResponse save(final Long id, final MesaRequest mesaRequest);

    MesaResponse save(MesaRequest request);

    MesaResponse update(Long id, MesaRequest request);

    void delete(final Long id);
}
