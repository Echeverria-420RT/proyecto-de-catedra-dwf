package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.PedidoRequest;
import sv.edu.udb.controller.response.PedidoResponse;
import sv.edu.udb.repository.ClienteRepository;
import sv.edu.udb.repository.MesaRepository;
import sv.edu.udb.repository.PedidoRepository;
import sv.edu.udb.repository.domain.Cliente;
import sv.edu.udb.repository.domain.Mesa;
import sv.edu.udb.repository.domain.Pedido;
import sv.edu.udb.service.PedidoService;
import sv.edu.udb.service.mapper.PedidoMapper;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @NonNull
    private final PedidoRepository pedidoRepository;
    @NonNull
    private final ClienteRepository clienteRepository;
    @NonNull
    private final MesaRepository mesaRepository;
    @NonNull
    private final PedidoMapper pedidoMapper;

    @Override
    public List<PedidoResponse> findAll() {
        return pedidoMapper.toPedidoResponseList(pedidoRepository.findAll());
    }

    @Override
    public PedidoResponse findById(final Long id) {
        return pedidoMapper.toPedidoResponse(
                pedidoRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID " + id))
        );
    }

    @Override
    public PedidoResponse save(final PedidoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getCliente_id())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID " + request.getCliente_id()));
        Mesa mesa = mesaRepository.findById(request.getMesa_id())
                .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con ID " + request.getMesa_id()));

        Pedido pedido = pedidoMapper.toPedido(request);
        pedido.setCliente(cliente);
        pedido.setMesa(mesa);
        pedido.setFechaHora(new Timestamp(System.currentTimeMillis()));

        return pedidoMapper.toPedidoResponse(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoResponse update(final Long id, final PedidoRequest request) {
        Pedido pedidoToUpdate = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID " + id));

        Cliente cliente = clienteRepository.findById(request.getCliente_id())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID " + request.getCliente_id()));
        Mesa mesa = mesaRepository.findById(request.getMesa_id())
                .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con ID " + request.getMesa_id()));

        pedidoToUpdate.setCliente(cliente);
        pedidoToUpdate.setMesa(mesa);
        pedidoToUpdate.setEstado(request.getEstado());
        pedidoToUpdate.setTotal(request.getTotal());

        return pedidoMapper.toPedidoResponse(pedidoRepository.save(pedidoToUpdate));
    }

    @Override
    public void delete(final Long id) {
        pedidoRepository.deleteById(id);
    }
}
