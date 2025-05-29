package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.ClienteRequest;
import sv.edu.udb.controller.response.ClienteResponse;
import sv.edu.udb.repository.ClienteRepository;
import sv.edu.udb.repository.domain.Cliente;
import sv.edu.udb.service.ClienteService;
import sv.edu.udb.service.mapper.ClienteMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class ClienteServiceImpl implements ClienteService {

    @NonNull
    private final ClienteRepository clienteRepository;
    @NonNull
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteResponse> findAll() {
        return clienteMapper.toClienteResponseList(clienteRepository.findAll());
    }

    @Override
    public ClienteResponse findById(final Long id) {
        return clienteMapper.toClienteResponse(
                clienteRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID " + id))
        );
    }

    @Override
    public ClienteResponse save(final ClienteRequest request) {
        Cliente cliente = clienteMapper.toCliente(request);
        return clienteMapper.toClienteResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponse update(final Long id, final ClienteRequest request) {
        Cliente clienteToUpdate = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID " + id));
        clienteToUpdate.setNombre(request.getNombre());
        clienteToUpdate.setApellido(request.getApellido());
        clienteToUpdate.setEmail(request.getEmail());
        clienteToUpdate.setTelefono(request.getTelefono());
        clienteToUpdate.setDireccion(request.getDireccion());
        return clienteMapper.toClienteResponse(clienteRepository.save(clienteToUpdate));
    }

    @Override
    public void delete(final Long id) {
        clienteRepository.deleteById(id);
    }
}
