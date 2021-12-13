/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asLtda.catalogoAccesorios.repository.crud;

import asLtda.catalogoAccesorios.model.Accessory;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author cabil
 */
public interface AccessoryCrudRepository extends MongoRepository<Accessory, String>{
    //Reto 5
    public List<Accessory> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Accessory> findByDescriptionLike(String description);
}
