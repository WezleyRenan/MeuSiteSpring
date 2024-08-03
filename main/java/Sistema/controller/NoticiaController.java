package Sistema.controller;

import Sistema.Output.NoticiaOutput;
import Sistema.input.NoticiaInput;
import Sistema.input.UsuarioInput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Sistema.Service.NoticiaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @PostMapping(value = "/adicionar" )
    public void cadastrarNoticia(@RequestBody @Valid NoticiaInput NoticiaIn) throws Exception {
        try {
            noticiaService.cadastrar(NoticiaIn);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping
    public List<NoticiaOutput> mostrarTodas() {
        return noticiaService.mostrarTodas();
    }

    @GetMapping("/Titulo")
    public List<NoticiaOutput> buscarPorTitulo(@RequestParam String titulo) {
        return noticiaService.buscarPorTitulo(titulo);
    }
    @GetMapping("/mostrarAtuais")
    public List<NoticiaOutput> mostrarAtuais() {
        return noticiaService.buscarNoticiasProximas();
    }

}
