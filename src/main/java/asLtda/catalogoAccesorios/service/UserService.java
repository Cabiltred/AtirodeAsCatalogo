package asLtda.catalogoAccesorios.service;

import asLtda.catalogoAccesorios.model.User;
import asLtda.catalogoAccesorios.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cabil
 */

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    
    public List<User> listarUsuarios(){
      return repositorio.listarUsuarios();
    }
    
    public Optional<User> obtenerUsuario(int id) {
        return repositorio.getUser(id);
    }

    public boolean existeEmail(String email) {
        return repositorio.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repositorio.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public User create(User user) {
        if (user.getId() == null) {
            return user;
        }else{
            Optional<User> provuser = repositorio.getUser(user.getId());
            if (provuser.isEmpty()) {
                if (existeEmail(user.getEmail()) == false) {
                    return repositorio.create(user);
                } else {
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                repositorio.update(userDb.get());
                return userDb.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = repositorio.getUser(id).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }   

}
