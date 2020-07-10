package br.univille.iglycemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.iglycemic.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByNomeAlimentoContains(String nomeAlimento);
    
}