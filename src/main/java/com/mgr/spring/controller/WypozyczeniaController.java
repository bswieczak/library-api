package com.mgr.spring.controller;

import com.mgr.spring.controller.message.SuccessMessage;
import com.mgr.spring.dto.WypozyczeniaRequestDto;
import com.mgr.spring.model.Wypozyczenia;
import com.mgr.spring.service.WypozyczeniaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/borrows")
public class WypozyczeniaController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WypozyczeniaController.class);

    private WypozyczeniaService wypozyczeniaService;

    @Autowired
    public WypozyczeniaController(WypozyczeniaService wypozyczeniaService) {
        this.wypozyczeniaService = wypozyczeniaService;
    }

    @GetMapping
    public ResponseEntity getWypozyczenia() {
        try {
            List<Wypozyczenia> wypozyczenia = wypozyczeniaService.loadAll();
            LOGGER.info("Load all 'wypozyczenia' - total count equals '{}'", wypozyczenia.size());
            return ResponseEntity.ok(wypozyczenia);
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' doesn't exists !", e);
        }
    }

    @RequestMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity getWypozyczenie(@PathVariable Long id) {
        try {
            final Optional<Wypozyczenia> wypozyczenie = wypozyczeniaService.loadOrder(id);
            if (wypozyczenie.isPresent()) {
                LOGGER.info("'Wypozyczenie' with id '{}' has bean loaded", id);
                return ResponseEntity.ok(wypozyczenie.get());
            }
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't load the 'wypozyczenie'", e);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenie' with id '"+id+"' doesn't exists !");
    }

    @PostMapping
    public ResponseEntity createWypozyczenie(@RequestBody WypozyczeniaRequestDto wypozyczenie) {
        try {
            final Wypozyczenia createdWypozyczenie = wypozyczeniaService.create(wypozyczenie);
            LOGGER.info("'Wypozyczenie' has been created successfully with id '{}'", createdWypozyczenie.getIdWypozyczenie());
            final SuccessMessage body = new SuccessMessage(HttpStatus.CREATED,
                    String.format("'Wypozyczenie' has been created successfully with id '%s'", createdWypozyczenie.getIdWypozyczenie()));
            body.setId(createdWypozyczenie.getIdWypozyczenie());
            return ResponseEntity.ok(body);
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenie' can't be created", e);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteWypozyczenie(@PathVariable Long id) {
        try {
            wypozyczeniaService.delete(id);
            LOGGER.info("'Wypozyczenie' with id '{}' has been deleted successfully", id);
            return ResponseEntity.ok(new SuccessMessage(HttpStatus.OK,
                    String.format("'Wypozyczenie' with id '%d' has been deleted successfully", id)));
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' can't be deleted", e);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateWypozyczenie(@PathVariable Long id, @RequestBody WypozyczeniaRequestDto wypozyczenie) {
        try {
            wypozyczeniaService.update(id, wypozyczenie);
            LOGGER.info("'Wypozyczenie' has been updated successfully - {}", wypozyczenie);
            return ResponseEntity.ok(new SuccessMessage(HttpStatus.OK,
                    String.format("'Wypozyczenie' with id '%d' has been updated successfully", id)));
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' can't be updated", e);
        }
    }

}
