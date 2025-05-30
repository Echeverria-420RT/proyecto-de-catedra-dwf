package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.CategoriaRequest;
import sv.edu.udb.controller.response.CategoriaResponse;
import sv.edu.udb.service.CategoriaService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaResponse> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("{id}")
    public CategoriaResponse findById(@PathVariable final Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CategoriaResponse save(@Valid @RequestBody final CategoriaRequest request) {
        return categoriaService.save(request);
    }

    @PutMapping("{id}")
    public CategoriaResponse update(@PathVariable final Long id,
                                    @Valid @RequestBody final CategoriaRequest request) {
        return categoriaService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        categoriaService.delete(id);
    }
}