package com.epam.project.dao.interfaces;

import com.epam.project.entity.Identifiable;
import com.epam.project.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Identifiable> {
    Optional<T> getById(Long id) throws DaoException;
    List<T> getAll() throws DaoException;
    void save(T item);
    void removeById(Long id);
}
