package br.univille.iglycemic.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
  
import br.univille.iglycemic.repository.UsuarioRepository;
import br.univille.iglycemic.model.Usuario;
@Service
public class MyUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UsuarioRepository repository; 
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(Usuario usuario){
        if (usuario.getSenha().length() != 0) 
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        repository.save(usuario);
    }

    public Usuario buscaUsuario(String nomeUsuario){
        return repository.findByeMail(nomeUsuario);
    }

    public Usuario buscaUsuarioSenha(String nomeUsuario, String senhaUsuario){
        return repository.findByeMailAndSenha(nomeUsuario, senhaUsuario);
    }
  
    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Usuario usuario = repository.findByeMail(nomeUsuario);
        return new User(usuario.geteMail(),usuario.getSenha(), new ArrayList<>());
    }  

    public Usuario getUserLogged(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = repository.findByeMail(authentication.getName());
        return usuario;
    }
      
}