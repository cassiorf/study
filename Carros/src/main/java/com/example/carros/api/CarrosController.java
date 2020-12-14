package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    // Buscar todos os carros
    @GetMapping
    public ResponseEntity<Iterable<Carro>> getCarros() {
        return ResponseEntity.ok(service.getCarros());
    }

    // Buscar carro por ID
    @GetMapping("/{id}")
    public ResponseEntity getCarrosById(@PathVariable("id") Long id) {
        Optional<Carro> carro = service.getCarrosById(id);

        return carro.isPresent() ?
                ResponseEntity.ok(carro.get()) :
                ResponseEntity.notFound().build();

        // MODOS ALTERNATIVOS
//      return carro
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());

//      if(carro.isPresent()){
//            return  ResponseEntity.ok(carro.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    // Buscar carro por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
        List<Carro> carros = service.getCarrosByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);

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
