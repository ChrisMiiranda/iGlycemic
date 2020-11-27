package br.univille.iglycemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.iglycemic.model.Medicao;
import br.univille.iglycemic.repository.MedicaoRepository;
import br.univille.iglycemic.service.MedicaoService;

@Service
public class MedicaoServiceImpl implements MedicaoService {

    @Autowired
    private MedicaoRepository repository;

 

    @Override
    public void save(Medicao medicao) {
        repository.save(medicao);
    }

    @Override
    public void delete(Medicao medicao) {
        repository.delete(medicao);
    }

    @Override
    public List<Medicao> getAll() {
        return repository.findAll();
    }
    
}