package com.southwind.repository;

import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> findAllByState(int state, int page, int limit);
    int countByState(int state);
    int countByUid(Long state);
    List<Order> findAllByUid(Long uid, int page, int limit);


}

