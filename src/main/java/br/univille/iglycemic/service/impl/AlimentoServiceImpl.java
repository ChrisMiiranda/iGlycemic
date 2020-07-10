package br.univille.iglycemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.iglycemic.model.Alimento;
import br.univille.iglycemic.repository.AlimentoRepository;
import br.univille.iglycemic.service.AlimentoService;

@Service
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    private AlimentoRepository repository;

 

    @Override
    public void save(Alimento alimento) {
        repository.save(alimento);
    }

    @Override
    public void delete(Alimento alimento) {
        repository.delete(alimento);
    }

    @Override
    public List<Alimento> getAll() {
        return repository.findAll();
    }
    
}