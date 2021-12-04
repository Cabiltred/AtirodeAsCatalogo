package asLtda.catalogoAccesorios.repository.crud;

import asLtda.catalogoAccesorios.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 *
 * @author cabil
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    
}
