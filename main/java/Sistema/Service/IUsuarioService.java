package Sistema.Service;

import Sistema.Output.UsuarioOutput;
import Sistema.input.UsuarioInput;
import Sistema.model.UsuarioModel;

import java.util.List;


public interface IUsuarioService {


    void cadastrar(UsuarioInput usuario) throws Exception;
    void deletartodos() throws Exception;
    void deletarPorId(int id) throws Exception;
    List<UsuarioOutput> findByNome(String nome) throws Exception;
    List<UsuarioOutput> findById(long id)throws Exception;
    List<UsuarioOutput> buscarTodos() throws Exception;

}
