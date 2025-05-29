package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.PlatoRequest;
import sv.edu.udb.controller.response.PlatoResponse;
import sv.edu.udb.repository.CategoriaRepository;
import sv.edu.udb.repository.PlatoRepository;
import sv.edu.udb.repository.domain.Categoria;
import sv.edu.udb.repository.domain.Plato;
import sv.edu.udb.service.PlatoService;
import sv.edu.udb.service.mapper.PlatoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    @NonNull
    private final PlatoRepository platoRepository;
    @NonNull
    private final CategoriaRepository categoriaRepository;
    @NonNull
    private final PlatoMapper platoMapper;

    @Override
    public List<PlatoResponse> findAll() {
        return platoMapper.toPlatoResponseList(platoRepository.findAll());
    }

    @Override
    public PlatoResponse findById(final Long id) {
        return platoMapper.toPlatoResponse(
                platoRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID " + id))
        );
    }

    @Override
    public PlatoResponse save(final PlatoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.getCategoria_id())
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con ID " + request.getCategoria_id()));
        Plato plato = platoMapper.toPlato(request);
        plato.setCategoria(categoria);
        return platoMapper.toPlatoResponse(platoRepository.save(plato));
    }

    @Override
    public PlatoResponse update(final Long id, final PlatoRequest request) {
        Plato platoToUpdate = platoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID " + id));
        Categoria categoria = categoriaRepository.findById(request.getCategoria_id())
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con ID " + request.getCategoria_id()));

        platoToUpdate.setNombre(request.getNombre());
        platoToUpdate.setDescripcion(request.getDescripcion());
        platoToUpdate.setPrecio(request.getPrecio());
        platoToUpdate.setDisponible(request.getDisponible());
        platoToUpdate.setCategoria(categoria);

        return platoMapper.toPlatoResponse(platoRepository.save(platoToUpdate));
    }

    @Override
    public void delete(final Long id) {
        platoRepository.deleteById(id);
    }
}
