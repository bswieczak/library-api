package com.mgr.spring.controller;

import com.mgr.spring.model.Order;
import com.mgr.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity getOrders() {
        List<Order> orders = orderService.loadAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOrder(@PathVariable Integer id) {
        Order order = orderService.loadOrder(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Order order){
        orderService.create(order);
        return ResponseEntity.ok("Order has been created successfully");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order has been created successfully");
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody Order order){
        orderService.update(order);
        return ResponseEntity.ok("Order has been created successfully");
    }

}
