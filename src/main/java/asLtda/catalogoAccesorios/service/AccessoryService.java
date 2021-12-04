/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asLtda.catalogoAccesorios.service;

import asLtda.catalogoAccesorios.model.Accessory;
import asLtda.catalogoAccesorios.model.User;
import asLtda.catalogoAccesorios.repository.AccessoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cabil
 */

@Service
public class AccessoryService {
    @Autowired
    private AccessoryRepository repositorio;
    
    public List<Accessory> listarAccesorios(){
        return repositorio.listarAccesorios();
    }
    
     public Optional<Accessory> getAccesory(String reference) {
        return repositorio.getAccessory(reference);
    }
    
    public Accessory create(Accessory accessory) {
        if (accessory.getReference() == null) {
            return accessory;
        }else{
            return repositorio.create(accessory);   
        }
    }

    public Accessory update(Accessory accessory) {
        if (accessory.getReference() != null) {
            Optional<Accessory> accessoryDb = repositorio.getAccessory(accessory.getReference());
            if (!accessoryDb.isEmpty()) {
                if (accessory.getBrand() != null) {
                    accessoryDb.get().setBrand(accessory.getBrand());
                }
                if (accessory.getCategory() != null) {
                    accessoryDb.get().setCategory(accessory.getCategory());
                }
                if (accessory.getMaterial() != null) {
                    accessoryDb.get().setMaterial(accessory.getMaterial());
                }
                if (accessory.getDescription() != null) {
                    accessoryDb.get().setDescription(accessory.getDescription());
                }
                if (accessory.getPrice() != 0.0) {
                    accessoryDb.get().setPrice(accessory.getPrice());
                }
                if (accessory.getQuantity() != 0) {
                    accessoryDb.get().setQuantity(accessory.getQuantity());
                }
                if (accessory.getPhotography() != null) {
                    accessoryDb.get().setPhotography(accessory.getPhotography());
                }
                accessoryDb.get().setAvailability(accessory.isAvailability());
                repositorio.update(accessoryDb.get());
                return accessoryDb.get();
            }else{
                return accessory;
            }
        }else{
            return accessory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            repositorio.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }   

}
