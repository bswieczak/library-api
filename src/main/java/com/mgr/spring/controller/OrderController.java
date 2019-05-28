package com.mgr.spring.controller;

import com.mgr.spring.controller.message.SuccessMessage;
import com.mgr.spring.model.Wypozyczenia;
import com.mgr.spring.service.WypozyczeniaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/borrows")
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private WypozyczeniaService wypozyczeniaService;

    @Autowired
    public OrderController(WypozyczeniaService wypozyczeniaService) {
        this.wypozyczeniaService = wypozyczeniaService;
    }

    @GetMapping
    public ResponseEntity getWypozyczenia() {
        try {
            List<Wypozyczenia> wypozyczenia = wypozyczeniaService.loadAll();
            LOGGER.info("all orders");
            return ResponseEntity.ok(wypozyczenia);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' doesn't exists !", e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOrder(@PathVariable Long id) {
        try {
            final Wypozyczenia wypozyczenie = wypozyczeniaService.loadOrder(id);
            LOGGER.info("wypozyczenie {}", id);
            return ResponseEntity.ok(wypozyczenie);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' doesn't exists !", e);
        }
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Wypozyczenia wypozyczenie) {
        try {
            wypozyczeniaService.create(wypozyczenie);
            return ResponseEntity.ok(new SuccessMessage(HttpStatus.CREATED,
                    "'Wypozyczenie' has been created successfully"));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' can't be created", e);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        try {
            wypozyczeniaService.delete(id);
            return ResponseEntity.ok(new SuccessMessage(HttpStatus.OK,
                    String.format("'Wypozyczenie' with id '%d' has been deleted successfully", id)));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' can't be deleted", e);
        }
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody Wypozyczenia wypozyczenie) {
        try {
            wypozyczeniaService.update(wypozyczenie);
            return ResponseEntity.ok(new SuccessMessage(HttpStatus.OK,
                    String.format("'Wypozyczenie' with id '%d' has been updated successfully", wypozyczenie.getIdWypozyczenie())));
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "'Wypozyczenia' can't be updated", e);
        }
    }

}
