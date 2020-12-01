package br.univille.iglycemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.iglycemic.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContains(String nome);
    Usuario findByeMail(String usuario);
    Usuario findByeMailAndSenha(String usuario,String senha);
}