package Sistema.Output;


import Sistema.model.CategoriaModel;
import Sistema.model.NoticiaModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ForeignKey;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaOutput {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;


    private String imagem;

    @NotNull(message = "A data de publicação é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @PastOrPresent(message = "A data de publicação deve ser no passado ou presente")
    private LocalDateTime dataPublicacao;

    private Long categoriaId;

    public static NoticiaOutput fromModel(NoticiaModel model){
        return NoticiaOutput.builder()
                .titulo(model.getTitulo())
                .dataPublicacao(model.getDataPublicacao())
                .imagem(model.getImagem())
                .descricao(model.getDescricao())
                .build();
    }
}
