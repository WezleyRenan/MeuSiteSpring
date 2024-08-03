package Sistema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Categoria_id")
    private Long categoriaId;

    @Column(name = "Categoria_nome")
    private String categoriaNome;


}
