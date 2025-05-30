package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.ClienteRequest;
import sv.edu.udb.controller.response.ClienteResponse;
import sv.edu.udb.service.ClienteService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public ClienteResponse findById(@PathVariable final Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteResponse save(@Valid @RequestBody final ClienteRequest request) {
        return clienteService.save(request);
    }

    @PutMapping("{id}")
    public ClienteResponse update(@PathVariable final Long id,
                                  @Valid @RequestBody final ClienteRequest request) {
        return clienteService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        clienteService.delete(id);
    }
}