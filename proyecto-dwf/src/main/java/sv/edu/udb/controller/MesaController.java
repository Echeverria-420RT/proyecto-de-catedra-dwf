package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.MesaRequest;
import sv.edu.udb.controller.response.MesaResponse;
import sv.edu.udb.service.MesaService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "mesas")
public class MesaController {

    private final MesaService mesaService;

    @GetMapping
    public List<MesaResponse> findAll() {
        return mesaService.findAll();
    }

    @GetMapping("{id}")
    public MesaResponse findById(@PathVariable final Long id) {
        return mesaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public MesaResponse save(@Valid @RequestBody final MesaRequest request) {
        return mesaService.save(request);
    }

    @PutMapping("{id}")
    public MesaResponse update(@PathVariable final Long id,
                               @Valid @RequestBody final MesaRequest request) {
        return mesaService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        mesaService.delete(id);
    }
}