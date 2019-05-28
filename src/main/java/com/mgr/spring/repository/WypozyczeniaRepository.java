package com.mgr.spring.repository;

import com.mgr.spring.model.Wypozyczenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WypozyczeniaRepository extends JpaRepository<Wypozyczenia, Long> {
}
