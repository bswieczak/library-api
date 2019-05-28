package com.mgr.spring.service;

import com.mgr.spring.model.Wypozyczenia;
import com.mgr.spring.repository.WypozyczeniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WypozyczeniaService {

    private WypozyczeniaRepository wypozyczeniaRepository;

    @Autowired
    public WypozyczeniaService(WypozyczeniaRepository wypozyczeniaRepository) {
        this.wypozyczeniaRepository = wypozyczeniaRepository;
    }

    public List<Wypozyczenia> loadAll() {
        return wypozyczeniaRepository.findAll();
    }

    public Wypozyczenia loadOrder(Long id) {
        return wypozyczeniaRepository.getOne(id);
    }

    @Transactional
    public void create(Wypozyczenia wypozyczenie) {
        wypozyczeniaRepository.save(wypozyczenie);
    }

    @Transactional
    public void delete(Long id) {
        wypozyczeniaRepository.deleteById(id);
    }

    @Transactional
    public void update(Wypozyczenia wypozyczenie) {
        wypozyczeniaRepository.save(wypozyczenie);
    }
}
