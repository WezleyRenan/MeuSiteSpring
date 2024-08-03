package Sistema.controller;

import Sistema.Output.CategoriaOutput;
import Sistema.input.CategoriaInput;
import Sistema.model.CategoriaModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Sistema.Service.CategoriaService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    @GetMapping(value = "/nome")
    public Object buscarCategoriasPorNome(@Valid CategoriaOutput categoria){
        return categoriaService.buscarCategoriasPorNome(categoria.getCategoriaNome());
    }
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Object getAllCategorias(){
        return categoriaService.getAllCategorias();
    }
    @PostMapping(value = "/adicionar" )
    public void cadastrarCategoria(@RequestBody @Valid CategoriaInput categoria) throws Exception {
        try {
            categoriaService.cadastrarCategoria(categoria);
            System.out.println("nova Categoria cadastrada");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }





}

