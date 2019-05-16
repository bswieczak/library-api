package com.mgr.spring.service;

import com.mgr.spring.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> loadAll();
}
