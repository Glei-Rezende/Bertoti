package com.example.carroproject.service;

import com.example.carroproject.model.Carro;
import com.example.carroproject.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }
}
