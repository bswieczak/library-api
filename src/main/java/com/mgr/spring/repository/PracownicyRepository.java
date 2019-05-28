package com.mgr.spring.repository;

import com.mgr.spring.model.Pracownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownicyRepository extends JpaRepository<Pracownicy, Integer> {
}
