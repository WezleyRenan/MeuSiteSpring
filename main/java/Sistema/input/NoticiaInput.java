package Sistema.input;

import Sistema.model.NoticiaModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class NoticiaInput {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;


    private String imagem;

    @NotNull(message = "A data de publicação é obrigatória")
    @PastOrPresent(message = "A data de publicação deve ser no passado ou presente")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sergipe")
    private LocalDateTime dataPublicacao;


    public NoticiaModel toModel(){
        return NoticiaModel.builder()
                .titulo(titulo)
                .dataPublicacao(dataPublicacao)
                .imagem(imagem)
                .descricao(descricao)
                .build();
    }
}