package asLtda.catalogoAccesorios.repository;

import asLtda.catalogoAccesorios.model.User;
import asLtda.catalogoAccesorios.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cabil
 */

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudRepositorio;
    
    public Optional<User> getUser(Integer id) {
        return crudRepositorio.findById(id);
    }
    
    public Optional<User> getUser(int id){
        return crudRepositorio.findById(id);
    }
    
    public User create(User user) {
        return crudRepositorio.save(user);
    }

    public void update(User user) {
        crudRepositorio.save(user);
    }
    
    public void delete(User user) {
        crudRepositorio.delete(user);
    }
    
    public List<User> listarUsuarios(){
      return crudRepositorio.findAll();
    } 

    public boolean existeEmail(String email) {
        Optional<User> usuario = crudRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return crudRepositorio.findByEmailAndPassword(email, password);           
    }

}
