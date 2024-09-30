package org.example.spring_exo_etudient.dao;

import org.example.spring_exo_etudient.entity.Etudient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudientRepository extends JpaRepository<Etudient, Integer> {

    List<Etudient> findByPrenom(String prenom);

}
