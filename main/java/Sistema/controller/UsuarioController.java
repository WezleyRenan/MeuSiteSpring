package Sistema.controller;

import Sistema.Service.UsuarioService;
import Sistema.input.CategoriaInput;
import Sistema.input.UsuarioInput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/adicionar" )
    public void cadastrarUsuario(@RequestBody @Valid UsuarioInput usuario) throws Exception {
        try {
            usuarioService.cadastrar(usuario);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping()
    public Object listarTodosUsuario() throws Exception {
        return usuarioService.buscarTodos();
    }

    @PostMapping(value = "/deletarTodos")
    public void deletarTodosUsuario() throws Exception {
        usuarioService.deletartodos();
    }


}
