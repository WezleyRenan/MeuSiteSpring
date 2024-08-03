package Sistema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Noticia")
public class NoticiaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Noticia_id")
    private Long noticiaId;

    @Column(columnDefinition = "TEXT", name = "descricao")
    private String descricao;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "Data_publicacao")
    private LocalDateTime dataPublicacao;


}
