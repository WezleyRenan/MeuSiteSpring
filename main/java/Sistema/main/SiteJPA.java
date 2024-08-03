package Sistema.main;

import Sistema.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import Sistema.repository.UsuarioRepository;

import java.util.List;


public class SiteJPA {
    @Component
    public class AppBancoJPA implements CommandLineRunner {
        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public void run(String... args) throws Exception {
            try {
                List<UsuarioModel> ls = usuarioRepository.findAll();
                for (UsuarioModel a : ls) {
                    System.out.println(a.getUsuarioNome());
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
