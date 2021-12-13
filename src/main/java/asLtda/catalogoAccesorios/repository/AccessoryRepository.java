package asLtda.catalogoAccesorios.repository;

import asLtda.catalogoAccesorios.model.Accessory;
import asLtda.catalogoAccesorios.repository.crud.AccessoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cabil
 */

@Repository
public class AccessoryRepository {
    @Autowired
    private AccessoryCrudRepository repositorio;
    
    public List<Accessory> listarAccesorios(){
        return repositorio.findAll();
    }
    
    public Optional<Accessory> getAccessory(String reference) {
        return repositorio.findById(reference);
    }

    public Accessory create(Accessory accessory) {
        return repositorio.save(accessory);
    }

    public void update(Accessory accessory) {
        repositorio.save(accessory);
    }

    public void delete(Accessory accessory) {
        repositorio.delete(accessory);
    }
  
    //Reto 5
    public List<Accessory> productsByPrice(double precio){
        return repositorio.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Accessory> findByDescriptionLike(String description){
	return repositorio.findByDescriptionLike(description);
    }
}
