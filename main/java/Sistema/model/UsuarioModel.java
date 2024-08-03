package Sistema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Usuario_id")
    private Long usuarioId;

    @Column(name = "Usuario_nome")
    private String usuarioNome;

    @Column(name = "Usuario_fone")

    private String usuarioFone;

    @Column(name = "Usuario_login", unique = true)
    private String usuarioLogin;

    @Column(name = "Usuario_email", unique = true)
    private String usuarioEmail;

    @Column (name = "Usuario_dtnascimento")
    private LocalDate usuarioDtnascimento;

    @Column(name = "Usuario_status")
    @Enumerated (EnumType.STRING)
    private UsuarioStatus usuarioStatus;

    public enum UsuarioStatus {
        ATIVO, INATIVO
    }
}
