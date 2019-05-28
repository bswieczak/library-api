package com.mgr.spring.service;

import com.mgr.spring.dto.WypozyczeniaRequestDto;
import com.mgr.spring.model.Czytelnicy;
import com.mgr.spring.model.Ksiazki;
import com.mgr.spring.model.Pracownicy;
import com.mgr.spring.model.Wypozyczenia;
import com.mgr.spring.repository.CzytelnicyRepository;
import com.mgr.spring.repository.KsiazkiRepository;
import com.mgr.spring.repository.PracownicyRepository;
import com.mgr.spring.repository.WypozyczeniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WypozyczeniaService {

    private WypozyczeniaRepository wypozyczeniaRepository;

    private CzytelnicyRepository czytelnicyRepository;

    private KsiazkiRepository ksiazkiRepository;

    private PracownicyRepository pracownicyRepository;

    @Autowired
    public WypozyczeniaService(WypozyczeniaRepository wypozyczeniaRepository,
                               CzytelnicyRepository czytelnicyRepository,
                               KsiazkiRepository ksiazkiRepository,
                               PracownicyRepository pracownicyRepository) {
        this.wypozyczeniaRepository = wypozyczeniaRepository;
        this.czytelnicyRepository = czytelnicyRepository;
        this.ksiazkiRepository = ksiazkiRepository;
        this.pracownicyRepository = pracownicyRepository;
    }

    public List<Wypozyczenia> loadAll() {
        return wypozyczeniaRepository.findAll();
    }

    public Optional<Wypozyczenia> loadOrder(Long id) {
        return wypozyczeniaRepository.findById(id);
    }

    @Transactional
    public Wypozyczenia create(WypozyczeniaRequestDto wypozyczenieDto) {
        final Wypozyczenia wypozyczenie = new Wypozyczenia();
        wypozyczenie.setDataWypozyczenia(new Date());
        final Optional<Czytelnicy> czytelnik = czytelnicyRepository.findById(wypozyczenieDto.getCzytelnikId());
        final Optional<Ksiazki> ksiazka = ksiazkiRepository.findById(wypozyczenieDto.getCzytelnikId());
        final Optional<Pracownicy> pracownikWypozyczenie = pracownicyRepository.findById(wypozyczenieDto.getCzytelnikId());

        if (czytelnik.isPresent() && ksiazka.isPresent() && pracownikWypozyczenie.isPresent()) {
            wypozyczenie.setCzytelnicy(czytelnik.get());
            wypozyczenie.setKsiazki(ksiazka.get());
            wypozyczenie.setPracownikWypozyczenie(pracownikWypozyczenie.get());
            return wypozyczeniaRepository.save(wypozyczenie);
        } else {
            throw new RuntimeException("Couldn't create 'wypożyczenie'");
        }
    }

    @Transactional
    public void delete(Long id) {
        wypozyczeniaRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, WypozyczeniaRequestDto wypozyczenieDto) {
        final Optional<Wypozyczenia> optionalWypozyczenie = this.loadOrder(id);
        if (optionalWypozyczenie.isPresent()) {
            final Wypozyczenia wypozyczenie = optionalWypozyczenie.get();
            wypozyczenie.setDataOddania(new Date());
            final Optional<Pracownicy> pracownikOddania = pracownicyRepository.findById(wypozyczenieDto.getPracownikOddanieId());
            wypozyczenie.setPracownikOddanie(pracownikOddania.get());
        } else {
            throw new RuntimeException("Couldn't update 'wypożyczenie'");
        }
    }
}
