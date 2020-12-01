package br.univille.iglycemic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import br.univille.iglycemic.model.Usuario;
import br.univille.iglycemic.service.impl.MyUserDetailsService;

@Component
public class StartApplication implements ApplicationRunner{
    @Autowired
    private MyUserDetailsService service;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuarioAdmin = service.buscaUsuario("chris");
        //System.out.println("Buscando");
        if(usuarioAdmin == null){
            //System.out.println("Nao achou");
            usuarioAdmin = new Usuario();
            usuarioAdmin.seteMail("chris");
            usuarioAdmin.setSenha("12345678");
            usuarioAdmin.setNome("Christopher");
            service.save(usuarioAdmin);
            System.out.println("Salva senha " + usuarioAdmin.getSenha());
        }
        System.out.println("Salva senha " + usuarioAdmin.getSenha());
    }

}