package com.cleverlance.academy.airlines.service;

import java.util.List;
import java.util.Optional;

public interface AbsCrudService<E, ID> {
    List<E> getAll();

    void delete(ID id);

    void update(E e);

    void create(E e);

    Optional<E> getById(ID id);
}
