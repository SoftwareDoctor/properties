/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-10-15 08:30:00
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-10-16 09:39:18
 * @FilePath: src/main/java/it/softwaredoctor/properties/controller/PropertyController.java
 * @Description: Controller per la gestione delle proprietà immobiliari.
 */
package it.softwaredoctor.properties.controller;

import it.softwaredoctor.properties.model.Property;
import it.softwaredoctor.properties.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    
    @GetMapping("/")
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<Void> addProperty(@RequestBody Property property) {
      propertyService.addProperty(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProperty(@PathVariable String id, @RequestParam String status) {
      propertyService.updateProperty(id, status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable String id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
