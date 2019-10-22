package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll(int page,int limit);

    int count();

    void deleteById(long id);
}
