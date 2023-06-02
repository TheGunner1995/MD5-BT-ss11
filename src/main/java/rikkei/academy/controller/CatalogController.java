package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.Catalog;
import rikkei.academy.service.catalog.ICatalogService;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;
    @GetMapping("/catalog")
    public ResponseEntity<List<Catalog>> listCatalog(){
        List<Catalog> catalogList = (List<Catalog>) catalogService.findAll();
        if (catalogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(catalogList,HttpStatus.OK);
        }
    }
    @PostMapping("createCatalog")
    public ResponseEntity<Catalog> createCatalog(@RequestBody Catalog catalog){
        return new ResponseEntity<>(catalogService.save(catalog), HttpStatus.CREATED);
    }

    @PutMapping("updateCatalog/{id}")
    public ResponseEntity<Catalog> updateCatalog(@PathVariable("id")Long id, Catalog catalog){
        Optional<Catalog> catalogOptional = catalogService.findById(id);
        if (catalogOptional.isPresent()){
            catalogService.save(catalog);
            return new ResponseEntity<>(catalog, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
