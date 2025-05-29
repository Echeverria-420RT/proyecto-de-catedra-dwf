package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.MesaRequest;
import sv.edu.udb.controller.response.MesaResponse;
import sv.edu.udb.repository.MesaRepository;
import sv.edu.udb.repository.domain.Mesa;
import sv.edu.udb.service.MesaService;
import sv.edu.udb.service.mapper.MesaMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class MesaServiceImpl implements MesaService {

    @NonNull
    private final MesaRepository mesaRepository;
    @NonNull
    private final MesaMapper mesaMapper;

    @Override
    public List<MesaResponse> findAll() {
        return mesaMapper.toMesaResponseList(mesaRepository.findAll());
    }

    @Override
    public MesaResponse findById(final Long id) {
        return mesaMapper.toMesaResponse(
                mesaRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con ID " + id))
        );
    }

    @Override
    public MesaResponse save(final MesaRequest request) {
        Mesa mesa = mesaMapper.toMesa(request);
        return mesaMapper.toMesaResponse(mesaRepository.save(mesa));
    }

    @Override
    public MesaResponse update(final Long id, final MesaRequest request) {
        Mesa mesaToUpdate = mesaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con ID " + id));

        mesaToUpdate.setNumero(request.getNumero());
        mesaToUpdate.setCapacidad(request.getCapacidad());
        mesaToUpdate.setEstado(request.getEstado());

        return mesaMapper.toMesaResponse(mesaRepository.save(mesaToUpdate));
    }

    @Override
    public void delete(final Long id) {
        mesaRepository.deleteById(id);
    }
}
