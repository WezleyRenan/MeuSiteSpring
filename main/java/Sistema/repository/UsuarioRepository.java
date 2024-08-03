package Sistema.repository;

import Sistema.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query (nativeQuery = true ,value = "DELETE FROM Usuario WHERE Usuario_id = ?;")
            void deletarId(long id);

    @Query(nativeQuery = true, value = "DELETE FROM Usuario")
            void deletarTodos();

    @Query(nativeQuery = true, value = "SELECT * FROM Usuario WHERE Usuario_nome = ?")
            List<UsuarioModel> buscarPorNome(String nome);

    @Query(nativeQuery = true,value = "SELECT * FROM Usuario WHERE Usuario_id = ?")
            List<UsuarioModel> buscarPorId(long id);

    @Query(nativeQuery = true , value = "SELECT * FROM Usuario")
            List<UsuarioModel> buscarTodos();


}
