package Sistema.Service;

import Sistema.Output.CategoriaOutput;
import Sistema.input.CategoriaInput;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaOutput> getAllCategorias();
    List<CategoriaOutput> buscarCategoriasPorNome(String termo);
    void cadastrarCategoria(CategoriaInput categoriaIn) throws Exception;
    void deletarCategoria(Long id) throws Exception;


}
