package sv.edu.udb.service.implementation;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.CategoriaRequest;
import sv.edu.udb.controller.response.CategoriaResponse;
import sv.edu.udb.repository.CategoriaRepository;
import sv.edu.udb.repository.domain.Categoria;
import sv.edu.udb.service.CategoriaService;
import sv.edu.udb.service.mapper.CategoriaMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @NonNull
    private final CategoriaRepository categoriaRepository;
    @NonNull
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaResponse> findAll() {
        return categoriaMapper.toCategoriaResponseList(categoriaRepository.findAll());
    }

    @Override
    public CategoriaResponse findById(final Long id) {
        return categoriaMapper.toCategoriaResponse(
                categoriaRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con ID " + id))
        );
    }

    @Override
    public CategoriaResponse save(final CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        return categoriaMapper.toCategoriaResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse update(final Long id, final CategoriaRequest categoriaRequest) {
        Categoria categoriaToUpdate = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con ID " + id));
        categoriaToUpdate.setNombre(categoriaRequest.getNombre());
        categoriaToUpdate.setDescripcion(categoriaRequest.getDescripcion());
        return categoriaMapper.toCategoriaResponse(categoriaRepository.save(categoriaToUpdate));
    }

    @Override
    public void delete(final Long id) {
        categoriaRepository.deleteById(id);
    }
}