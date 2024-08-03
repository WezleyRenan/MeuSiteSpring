package Sistema.repository;

import Sistema.model.NoticiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM Noticia WHERE Titulo LIKE ?1")
    List<NoticiaModel> buscarPorTitulo(String titulo);

    @Query(nativeQuery = true,
            value = "SELECT * from Noticia")
    List<NoticiaModel> mostrarNoticias();

    @Query(nativeQuery = true , value = "SELECT * FROM Noticia ORDER BY ABS(TIMESTAMPDIFF(DAY, Data_publicacao, CURDATE())) ASC;")
    List<NoticiaModel> mostrarNoticiasProximas();

}


