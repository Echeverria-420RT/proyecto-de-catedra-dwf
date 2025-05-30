package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.DetallePedidoRequest;
import sv.edu.udb.controller.response.DetallePedidoResponse;
import sv.edu.udb.service.DetallePedidoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "detalles-pedido")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedidoResponse> findAll() {
        return detallePedidoService.findAll();
    }

    @GetMapping("{id}")
    public DetallePedidoResponse findById(@PathVariable final Long id) {
        return detallePedidoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public DetallePedidoResponse save(@Valid @RequestBody final DetallePedidoRequest request) {
        return detallePedidoService.save(request);
    }

    @PutMapping("{id}")
    public DetallePedidoResponse update(@PathVariable final Long id,
                                        @Valid @RequestBody final DetallePedidoRequest request) {
        return detallePedidoService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        detallePedidoService.delete(id);
    }
}