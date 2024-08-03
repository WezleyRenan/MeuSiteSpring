package Sistema.repository;

import Sistema.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    @Query(nativeQuery = true, value = "select * from categoria where Categoria_nome like ?1")
    List<CategoriaModel> buscarCategoriaPorNome(String nome);

    @Query(nativeQuery = true, value = "select * from categoria")
    List<CategoriaModel> getAllCategorias();

    @Query(nativeQuery = true , value = "DELETE FROM categoria WHERE Categoria_id = ?1" )
    List<CategoriaModel> deletarCategoria(Long id);

}

