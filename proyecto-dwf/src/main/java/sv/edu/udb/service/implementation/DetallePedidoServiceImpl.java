package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.DetallePedidoRequest;
import sv.edu.udb.controller.response.DetallePedidoResponse;
import sv.edu.udb.repository.DetallePedidoRepository;
import sv.edu.udb.repository.PedidoRepository;
import sv.edu.udb.repository.PlatoRepository;
import sv.edu.udb.repository.domain.DetallePedido;
import sv.edu.udb.repository.domain.Pedido;
import sv.edu.udb.repository.domain.Plato;
import sv.edu.udb.service.DetallePedidoService;
import sv.edu.udb.service.mapper.DetallePedidoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @NonNull
    private final DetallePedidoRepository detalleRepository;
    @NonNull
    private final PedidoRepository pedidoRepository;
    @NonNull
    private final PlatoRepository platoRepository;
    @NonNull
    private final DetallePedidoMapper mapper;

    @Override
    public List<DetallePedidoResponse> findAll() {
        return mapper.toDetallePedidoResponseList(detalleRepository.findAll());
    }

    @Override
    public DetallePedidoResponse findById(final Long id) {
        return mapper.toDetallePedidoResponse(
                detalleRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Detalle no encontrado con ID " + id))
        );
    }

    @Override
    public DetallePedidoResponse save(final DetallePedidoRequest request) {
        Pedido pedido = pedidoRepository.findById(request.getPedido_id())
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID " + request.getPedido_id()));
        Plato plato = platoRepository.findById(request.getPlato_id())
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID " + request.getPlato_id()));

        DetallePedido detalle = mapper.toDetallePedido(request);
        detalle.setPedido(pedido);
        detalle.setPlato(plato);

        return mapper.toDetallePedidoResponse(detalleRepository.save(detalle));
    }

    @Override
    public DetallePedidoResponse update(final Long id, final DetallePedidoRequest request) {
        DetallePedido detalleToUpdate = detalleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detalle no encontrado con ID " + id));

        Plato plato = platoRepository.findById(request.getPlato_id())
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID " + request.getPlato_id()));

        detalleToUpdate.setPlato(plato);
        detalleToUpdate.setCantidad(request.getCantidad());
        detalleToUpdate.setPrecioUnitario(request.getPrecio_unitario());
        detalleToUpdate.setOpciones(request.getOpciones());
        detalleToUpdate.setNotas(request.getNotas());

        return mapper.toDetallePedidoResponse(detalleRepository.save(detalleToUpdate));
    }

    @Override
    public void delete(final Long id) {
        detalleRepository.deleteById(id);
    }
}
