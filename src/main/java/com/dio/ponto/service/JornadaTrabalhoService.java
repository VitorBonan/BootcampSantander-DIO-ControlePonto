package com.dio.ponto.service;

import com.dio.ponto.model.JornadaTrabalho;
import com.dio.ponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {

    JornadaTrabalhoRepository jornadaTrabalhoRepository;

    @Autowired
    public JornadaTrabalhoService(JornadaTrabalhoRepository jornadaTrabalhoRepository) {
        this.jornadaTrabalhoRepository = jornadaTrabalhoRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public Optional<JornadaTrabalho> getJornada(long idJornada) {
        return jornadaTrabalhoRepository.findById(idJornada);
    }

    public List<JornadaTrabalho> listJornada() {
        return jornadaTrabalhoRepository.findAll();
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public void deleteJornada(long idJornada) {
        jornadaTrabalhoRepository.deleteById(idJornada);
    }
}
