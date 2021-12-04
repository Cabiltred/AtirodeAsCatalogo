/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asLtda.catalogoAccesorios.repository.crud;

import asLtda.catalogoAccesorios.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cabil
 */
public interface AccessoryCrudRepository extends MongoRepository<Accessory, String>{
    
}
