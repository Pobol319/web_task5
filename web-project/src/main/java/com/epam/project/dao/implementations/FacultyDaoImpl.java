package com.epam.project.dao.implementations;

import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.FacultyDao;
import com.epam.project.entity.Faculty;
import com.epam.project.entity.FacultyEnum;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class FacultyDaoImpl extends AbstractDao<Faculty> implements FacultyDao {
    public static final String TABLE = "faculties";

    public FacultyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Faculty> findFacultyByName(FacultyEnum name) {
        return Optional.empty();
    }

    @Override
    public Optional<Faculty> getById(Long id) {
        return Optional.empty();
    }


    @Override
    public void save(Faculty item) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    protected String getTableName() {
        return TABLE;
    }
}
