package Sistema.Output;

import Sistema.model.UsuarioModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutput {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String usuarioNome;

    @NotBlank(message = "O login é obrigatório")
    @Size(min = 6, max = 50, message = "O login deve ter entre 6 e 50 caracteres")
    private String usuarioLogin;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Digite um email válido")
    private String usuarioEmail;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser no passado")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sergipe")
    private LocalDate usuarioDtnascimento;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(min = 10, max = 20, message = "O telefone deve ter entre 10 e 20 caracteres")
    private String usuarioFone;

    public static UsuarioOutput fromModel(UsuarioModel model){
        return UsuarioOutput.builder()
                .usuarioEmail(model.getUsuarioEmail())
                .usuarioNome(model.getUsuarioNome())
                .usuarioLogin(model.getUsuarioLogin())
                .usuarioDtnascimento(model.getUsuarioDtnascimento())
                .usuarioFone(model.getUsuarioFone())
                .build();

    }
}
