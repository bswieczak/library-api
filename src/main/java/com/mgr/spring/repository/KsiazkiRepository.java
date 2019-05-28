package com.mgr.spring.repository;

import com.mgr.spring.model.Ksiazki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsiazkiRepository extends JpaRepository<Ksiazki, Integer> {
}
