package com.example.carroproject.controller;

import com.example.carroproject.model.Carro;
import com.example.carroproject.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> getAllCarros() {
        return carroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Carro> getCarroById(@PathVariable Long id) {
        return carroService.findById(id);
    }

    @PostMapping
    public Carro createCarro(@RequestBody Carro carro) {
        return carroService.save(carro);
    }

    @DeleteMapping("/{id}")
    public void deleteCarro(@PathVariable Long id) {
        carroService.deleteById(id);
    }
}
