package org.example.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {

    T create(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    T update(T entity);

    void deleteById(ID id);

}
