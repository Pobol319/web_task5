package com.epam.project.dao.implementations;

import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.PointsOnSubjectDao;
import com.epam.project.entity.PointsOnSubject;

import java.sql.Connection;
import java.util.Optional;

public class PointsOnSubjectDaoImpl extends AbstractDao<PointsOnSubject> implements PointsOnSubjectDao {
    public PointsOnSubjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<PointsOnSubject> findPointsOnSubjectByPoints(int points) {
        return Optional.empty();
    }

    @Override
    public Optional<PointsOnSubject> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(PointsOnSubject item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
