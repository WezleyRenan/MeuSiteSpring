package Sistema.input;

import Sistema.model.CategoriaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaInput {
    private long categoriaId;
    @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(min = 3, max = 100, message = "O nome da categoria deve ter entre 3 e 100 caracteres")
    private String categoriaNome;

    public CategoriaModel toModel(){
        return CategoriaModel.builder()
                .categoriaId(categoriaId)
                .categoriaNome(categoriaNome)
                .build();
    }
}
