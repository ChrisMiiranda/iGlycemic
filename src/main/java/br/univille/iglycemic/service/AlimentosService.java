package br.univille.iglycemic.service;

import org.springframework.stereotype.Service;

import java.util.List;

import br.univille.iglycemic.model.Alimentos;

@Service
public interface AlimentosService {
    
    void save(Alimentos alimento);
    void delete(Alimentos alimento);
    List<Alimentos> getAll();
}