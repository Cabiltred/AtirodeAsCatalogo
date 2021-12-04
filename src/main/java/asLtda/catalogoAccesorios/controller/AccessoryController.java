/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package asLtda.catalogoAccesorios.controller;

import asLtda.catalogoAccesorios.model.Accessory;
import asLtda.catalogoAccesorios.model.User;
import asLtda.catalogoAccesorios.service.AccessoryService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author cabil
 */
@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class AccessoryController {
    @Autowired
    private AccessoryService servicio;
    
    @GetMapping("/all")
    public List<Accessory> listarAccesorios() {
        return servicio.listarAccesorios();
    }
    
    @GetMapping("/{reference}")
    public Optional<Accessory> getAccesory(@PathVariable("reference") String reference) {
        return servicio.getAccesory(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory create(@RequestBody Accessory accessory) {
        return servicio.create(accessory);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory update(@RequestBody Accessory accessory) {
        return servicio.update(accessory);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }
}
