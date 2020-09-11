package br.univille.iglycemic.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.iglycemic.model.Alimento;
import br.univille.iglycemic.service.AlimentoService;

@RestController
@RequestMapping("/api/v1/alimentos")
public class AlimentoControllerApi {
    @Autowired
    private AlimentoService service;

    @GetMapping
    public ResponseEntity<List<Alimento>> getAll() {
        List<Alimento> lista = service.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> getById(@PathVariable("id") Alimento alimento) {
        return new ResponseEntity<>(alimento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Alimento> save (@RequestBody Alimento alimento){
        service.save(alimento);
        return new ResponseEntity<>(alimento, HttpStatus.OK);
    }
}