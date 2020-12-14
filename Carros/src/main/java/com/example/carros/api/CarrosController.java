package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    // Buscar todos os carros
    @GetMapping
    public Iterable<Carro> getCarros() {
        return service.getCarros();
    }

    // Buscar carro por ID
    @GetMapping("/{id}")
    public Optional<Carro> getCarrosById(@PathVariable("id") Long id) {
        return service.getCarrosById(id);
    }

    // Buscar carro por tipo
    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo) {
        return service.getCarrosByTipo(tipo);
    }

    // Post carro
    @PostMapping
    public String post(@RequestBody Carro carro) {
        Carro c = service.insert(carro);
        return "Carro " + c.getId() + " salvo com sucesso";
    }

    // Uppdate carro
    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        Carro c = service.update(carro, id);
        return "Carro " + c.getId() + " atualizado com sucesso";
    }

    // Delete carro
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "Carro " + id + " deletado com sucesso";
    }

}
