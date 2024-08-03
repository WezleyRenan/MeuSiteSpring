package Sistema.Output;

import Sistema.model.CategoriaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaOutput{

 @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(min = 3, max = 100, message = "O nome da categoria deve ter entre 3 e 100 caracteres")
    private String categoriaNome;

    public static CategoriaOutput fromModel(CategoriaModel model){
        return CategoriaOutput.builder()
                .categoriaNome(model.getCategoriaNome())
                .build();
    }

}
