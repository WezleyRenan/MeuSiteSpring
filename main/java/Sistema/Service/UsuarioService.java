package Sistema.Service;

import Sistema.Output.UsuarioOutput;
import Sistema.input.UsuarioInput;
import Sistema.model.UsuarioModel;
import Sistema.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuariorepository;

    @Override
    public void cadastrar(UsuarioInput usuarioIn) throws Exception {
        UsuarioModel usuario = usuarioIn.toModel();
        if (usuario.getUsuarioNome() == null || usuario.getUsuarioNome().isEmpty()){
            throw new Exception("nome vazio");
        }
        usuariorepository.save(usuario);
    }



    @Override
    public List<UsuarioOutput> buscarTodos() throws Exception {
        return toOut(usuariorepository.buscarTodos());

    }

    @Override
    public void deletartodos() throws Exception {
        usuariorepository.deletarTodos();
    }

    @Override
    public void deletarPorId(int id) throws Exception {
        usuariorepository.deletarId(id);
    }


    @Override
    public List<UsuarioOutput> findByNome(String nome) throws Exception {
        return toOut(usuariorepository.buscarPorNome(nome));
    }

    @Override
    public List<UsuarioOutput> findById(long id) throws Exception {
        return toOut(usuariorepository.buscarPorId(id));
    }

    public List<UsuarioOutput> toOut(List<UsuarioModel> usuarioM) {
        List<UsuarioOutput> UsuarioOut = new ArrayList<>();
        usuarioM.forEach(model -> {
            UsuarioOut.add(UsuarioOutput.fromModel(model));
        });
        return UsuarioOut;
    }

    }
