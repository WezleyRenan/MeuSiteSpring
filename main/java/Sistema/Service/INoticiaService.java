package Sistema.Service;

import Sistema.Output.NoticiaOutput;
import Sistema.input.NoticiaInput;
import Sistema.model.NoticiaModel;

import java.util.List;

public interface INoticiaService {

    List<NoticiaOutput> buscarPorTitulo(String titulo);
    List<NoticiaOutput> buscarNoticiasProximas();
    List<NoticiaOutput> mostrarTodas();
    void cadastrar(NoticiaInput noticiaIn) throws Exception;
}
