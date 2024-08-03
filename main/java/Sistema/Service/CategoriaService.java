package Sistema.Service;

import Sistema.Output.CategoriaOutput;
import Sistema.input.CategoriaInput;
import Sistema.model.CategoriaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Sistema.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaOutput> buscarCategoriasPorNome(String nome) {
        return toOut(categoriaRepository.buscarCategoriaPorNome(nome));
    }

    @Override
    public void cadastrarCategoria(CategoriaInput categoriaIn) throws Exception {
        CategoriaModel categoria = categoriaIn.toModel();
        if (categoria.getCategoriaNome() == null && categoria.getCategoriaNome().trim().isEmpty()) {
            throw new Exception ("nome da categoria esta vazio!!!");
        }
        categoriaRepository.save(categoria);
    }

    @Override
    public void deletarCategoria(Long id) throws Exception {
        categoriaRepository.deletarCategoria(id);
    }

    @Override
    public List<CategoriaOutput> getAllCategorias(){
        return toOut(categoriaRepository.getAllCategorias());
    }

    public List<CategoriaOutput> toOut(List<CategoriaModel> categoriaM) {
        List<CategoriaOutput> categoriaOut = new ArrayList<>();
        categoriaM.forEach(model -> {
            categoriaOut.add(CategoriaOutput.fromModel(model));
        });
        return categoriaOut;
    }
}
