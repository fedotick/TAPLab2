package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {

    T create(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    T update(T entity);

    void deleteById(ID id);

}
