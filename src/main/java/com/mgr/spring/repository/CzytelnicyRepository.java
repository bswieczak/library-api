package com.mgr.spring.repository;

import com.mgr.spring.model.Czytelnicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzytelnicyRepository extends JpaRepository<Czytelnicy, Integer> {
}
