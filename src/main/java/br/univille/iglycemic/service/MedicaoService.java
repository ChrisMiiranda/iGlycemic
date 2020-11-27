package br.univille.iglycemic.service;

import org.springframework.stereotype.Service;

import java.util.List;

import br.univille.iglycemic.model.Medicao;

@Service
public interface MedicaoService {
    
    void save(Medicao medicao);
    void delete(Medicao medicao);
    List<Medicao> getAll();
}