package com.dio.ponto.controller;

import com.dio.ponto.model.JornadaTrabalho;
import com.dio.ponto.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.saveJornada(jornadaTrabalho);
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornada(@PathVariable("idJornada") long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaTrabalhoService.getJornada(idJornada)
                .orElseThrow(() -> new NoSuchElementException("Jornada não encontrada.")));
    }

    @GetMapping
    public List<JornadaTrabalho> listJornada() {
        return jornadaTrabalhoService.listJornada();
    }

    @PutMapping("/{idJornada}")
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> deleteJornada(@PathVariable("idJornada") long idJornada) throws Exception {
        try {
            jornadaTrabalhoService.deleteJornada(idJornada);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
