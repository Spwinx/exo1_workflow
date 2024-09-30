package org.example.spring_exo_etudient.service;

import org.example.spring_exo_etudient.dao.EtudientRepository;
import org.example.spring_exo_etudient.entity.Etudient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudientJpaService {
    private EtudientRepository etudientRepository;

    public EtudientJpaService(EtudientRepository etudientRepository) {
        this.etudientRepository = etudientRepository;
    }

    public List<Etudient> findAll(){
        return etudientRepository.findAll();
    }

    public Etudient findById(int id){
        return etudientRepository.findById(id).orElse(null);
    }

    public Etudient save(Etudient etudient){
        return etudientRepository.save(etudient);
    }

    public void delete(Etudient etudient){
        etudientRepository.delete(etudient);
    }

    public List<Etudient> findByPrenom(String prenom){
        return etudientRepository.findByPrenom(prenom);
    }
}
