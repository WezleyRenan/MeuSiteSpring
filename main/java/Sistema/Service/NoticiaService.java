package Sistema.Service;

import Sistema.Output.NoticiaOutput;
import Sistema.input.NoticiaInput;
import Sistema.input.UsuarioInput;
import Sistema.model.NoticiaModel;
import Sistema.model.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Sistema.repository.NoticiaRepository;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticiaService implements INoticiaService{

    @Autowired
    private NoticiaRepository noticiaRepository;


    @Override
    public void cadastrar(NoticiaInput noticiaIn) throws Exception {
        NoticiaModel noticia = noticiaIn.toModel();
        if (noticia.getTitulo() == null || noticia.getTitulo().isEmpty()){
            throw new Exception("nome da noticia vazio");
        }
        noticiaRepository.save(noticia);
    }

    @Override
    public List<NoticiaOutput> buscarPorTitulo(String titulo) {
        return toOut(noticiaRepository.buscarPorTitulo(titulo));
    }

    @Override
    public List<NoticiaOutput> buscarNoticiasProximas() {
        return toOut(noticiaRepository.mostrarNoticiasProximas());
    }

    @Override
    public List<NoticiaOutput> mostrarTodas() {
        return toOut(noticiaRepository.mostrarNoticias());
    }

    public List<NoticiaOutput> toOut(List<NoticiaModel> NoticiaM) {
        List<NoticiaOutput> NoticiaOut = new ArrayList<>();
        NoticiaM.forEach(model -> {
            NoticiaOut.add(NoticiaOutput.fromModel(model));
        });
        return NoticiaOut;
    }

}