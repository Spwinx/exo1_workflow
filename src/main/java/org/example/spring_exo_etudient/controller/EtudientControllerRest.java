package org.example.spring_exo_etudient.controller;

import org.example.spring_exo_etudient.entity.Etudient;
import org.example.spring_exo_etudient.service.EtudientJpaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/etudient/")
public class EtudientControllerRest {

    private EtudientJpaService etudientJpaService;

    private EtudientControllerRest (EtudientJpaService etudientJpaService) {
        this.etudientJpaService = etudientJpaService;
    }

    @GetMapping
    public ResponseEntity<List<Etudient>> getAll() {
        List<Etudient> etudients = etudientJpaService.findAll();
        return ResponseEntity.ok(etudients);
    }

    @GetMapping("{id}")
    public ResponseEntity<Etudient> getById(@PathVariable int id) {
        Etudient etudient = etudientJpaService.findById(id);
        return ResponseEntity.ok(etudient);
    }

    @PostMapping
    public ResponseEntity<Etudient> create(@Validated @RequestBody Etudient etudient) {
        etudientJpaService.save(etudient);
        return ResponseEntity.ok(etudient);
    }

    @GetMapping("update/{id}")
    public ResponseEntity<Etudient> update(@PathVariable int id, @RequestBody Etudient etudient) {
        Etudient etudient1 = etudientJpaService.findById(id);
        if (etudient1 == null) {
            return ResponseEntity.notFound().build();
        }
        
        etudient1.setNom(etudient.getNom());
        etudient1.setPrenom(etudient.getPrenom());
        etudient1.setEmail(etudient.getEmail());
        etudient1.setAge(etudient.getAge());
        
        etudientJpaService.save(etudient1);

        return ResponseEntity.ok(etudient1);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Etudient> delete(@PathVariable int id) {
        Etudient etudient = etudientJpaService.findById(id);
        etudientJpaService.delete(etudient);
        return ResponseEntity.ok(etudient);
    }
}
