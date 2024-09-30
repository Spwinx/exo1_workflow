package org.example.spring_exo_etudient.dao;

import org.example.spring_exo_etudient.entity.Admin;
import org.example.spring_exo_etudient.entity.Etudient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
