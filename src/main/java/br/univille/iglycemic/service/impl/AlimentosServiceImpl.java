package br.univille.iglycemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.iglycemic.model.Alimentos;
import br.univille.iglycemic.repository.AlimentosRepository;
import br.univille.iglycemic.service.AlimentosService;

@Service
public class AlimentosServiceImpl implements AlimentosService {

    @Autowired
    private AlimentosRepository repository;

    public AlimentosServiceImpl() {
    }

    @Override
    public void save(Alimentos alimento) {
        repository.save(alimento);
    }

    @Override
    public void delete(Alimentos alimento) {
        repository.delete(alimento);
    }

    @Override
    public List<Alimentos> getAll() {
        return repository.findAll();
    }
    
}