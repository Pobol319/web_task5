package com.epam.project.dao.implementations;

import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.StatementDao;
import com.epam.project.entity.Statement;

import java.sql.Connection;
import java.util.Date;
import java.util.Optional;

public class StatementDaoImpl extends AbstractDao<Statement> implements StatementDao {
    public StatementDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<Statement> findStatementByDate(Date date) {
        return Optional.empty();
    }

    @Override
    public Optional<Statement> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Statement item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
