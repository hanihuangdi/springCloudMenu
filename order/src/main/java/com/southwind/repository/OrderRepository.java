package com.southwind.repository;

import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> findAllByStatus(int status, int page, int limit);
}

