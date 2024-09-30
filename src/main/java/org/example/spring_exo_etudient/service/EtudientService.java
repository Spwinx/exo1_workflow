//package org.example.spring_exo_etudient.service;
//
//import org.example.spring_exo_etudient.entity.Etudient;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EtudientService {
//
//    private List<Etudient> etudients;
//    private int id = 4;
//
//    public EtudientService() {
//        etudients = new ArrayList<>();
//
//        Etudient e1 = new Etudient(1, "Titi", "Riri", "Titi@gmail.com", 20);
//        Etudient e2 = new Etudient(2, "Toto", "Roro", "Toto@gmail.com", 17);
//        Etudient e3 = new Etudient(3, "Tata", "Rara", "Tata@gmail.com", 24);
//
//        etudients.add(e1);
//        etudients.add(e2);
//        etudients.add(e3);
//    }
//
//    public void setEtudients(Etudient etudient) {
//
//        etudient.setId(id++);
//        etudients.add(etudient);
//    }
//
//    public List<Etudient> getEtudients() {
//        return etudients;
//    }
//
//    public List<Etudient> getEtudientsByName(String name) {
//        return etudients.stream().filter(e -> e.getPrenom().equals(name)).toList();
//    }
//
//    public Etudient getEtudientById(int id) {
//        return etudients.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
//    }
//
//    public void deleteEtudientByID(int id) {
//        etudients.removeIf(e -> e.getId() == id);
//    }
//
//    public void updateEtudient(Etudient majEtudient) {
//        Etudient BDDEtudient = getEtudientById(majEtudient.getId());
//        BDDEtudient.setPrenom(majEtudient.getPrenom());
//        BDDEtudient.setNom(majEtudient.getNom());
//        BDDEtudient.setEmail(majEtudient.getEmail());
//        BDDEtudient.setAge(majEtudient.getAge());
//    }
//}