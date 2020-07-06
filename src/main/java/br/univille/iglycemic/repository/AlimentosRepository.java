package br.univille.iglycemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.iglycemic.model.Alimentos;

@Repository
public interface AlimentosRepository extends JpaRepository<Alimentos, Long> {
    List<Alimentos> findByNomeAlimentoContains(String nomeAlimento);
    
}