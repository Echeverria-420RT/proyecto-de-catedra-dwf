package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.PedidoRequest;
import sv.edu.udb.controller.response.PedidoResponse;
import sv.edu.udb.service.PedidoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public List<PedidoResponse> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("{id}")
    public PedidoResponse findById(@PathVariable final Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public PedidoResponse save(@Valid @RequestBody final PedidoRequest request) {
        return pedidoService.save(request);
    }

    @PutMapping("{id}")
    public PedidoResponse update(@PathVariable final Long id,
                                 @Valid @RequestBody final PedidoRequest request) {
        return pedidoService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        pedidoService.delete(id);
    }
}