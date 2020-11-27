package br.univille.iglycemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.iglycemic.model.Medicao;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
    List<Medicao> findByglicemiaContains(String glicemia);
    
}