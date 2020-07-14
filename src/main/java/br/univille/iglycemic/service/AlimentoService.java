package br.univille.iglycemic.service;

import org.springframework.stereotype.Service;

import java.util.List;

import br.univille.iglycemic.model.Alimento;

@Service
public interface AlimentoService {
    
    void save(Alimento alimento);
    void delete(Alimento alimento);
    List<Alimento> getAll();
}