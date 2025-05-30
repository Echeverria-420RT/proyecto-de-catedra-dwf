package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.PlatoRequest;
import sv.edu.udb.controller.response.PlatoResponse;
import sv.edu.udb.service.PlatoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "platos")
public class PlatoController {

    private final PlatoService platoService;

    @GetMapping
    public List<PlatoResponse> findAll() {
        return platoService.findAll();
    }

    @GetMapping("{id}")
    public PlatoResponse findById(@PathVariable final Long id) {
        return platoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public PlatoResponse save(@Valid @RequestBody final PlatoRequest request) {
        return platoService.save(request);
    }

    @PutMapping("{id}")
    public PlatoResponse update(@PathVariable final Long id,
                                @Valid @RequestBody final PlatoRequest request) {
        return platoService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        platoService.delete(id);
    }
}