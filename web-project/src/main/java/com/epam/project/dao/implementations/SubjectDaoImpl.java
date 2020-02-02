package com.epam.project.dao.implementations;

import com.epam.project.builder.SubjectRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.SubjectDao;
import com.epam.project.entity.Subject;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.Optional;


public class SubjectDaoImpl extends AbstractDao<Subject> implements SubjectDao {
    public static final String TABLE = "subjects";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM subjects WHERE subject_id = ?";

    public SubjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public Optional<Subject> findSubjectByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> getById(Long id) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_ID, new SubjectRowMapper(), id);
    }

    @Override
    public void save(Subject item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
