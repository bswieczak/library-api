package com.mgr.spring.service;

import com.mgr.spring.model.Order;
import com.mgr.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> loadAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order loadOrder(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
