package sv.edu.udb.service;

import sv.edu.udb.controller.request.CategoriaRequest;
import sv.edu.udb.controller.response.CategoriaResponse;

import java.util.List;

public interface CategoriaService {
    List<CategoriaResponse> findAll();
    CategoriaResponse findById(final Long id);
    CategoriaResponse save(final CategoriaRequest categoriaRequest);
    CategoriaResponse update(final Long idd, final CategoriaRequest categoriaRequest);
    void delete(final Long id);
}