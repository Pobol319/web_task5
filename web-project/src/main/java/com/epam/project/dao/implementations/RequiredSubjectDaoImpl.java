package com.epam.project.dao.implementations;

import com.epam.project.builder.RequiredSubjectRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.RequiredSubjectDao;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RequiredSubjectDaoImpl extends AbstractDao<RequiredSubject> implements RequiredSubjectDao {
    public static final String TABLE = "required_subjects";
    private static final String QUERY_FIND_SUBJECT_ID_BY_FACULTY_ID = "SELECT * FROM" +
            " required_subjects WHERE faculties_faculties_id = ?";

    public RequiredSubjectDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public Optional<RequiredSubject> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(RequiredSubject item) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public List<RequiredSubject> findSubjectIdByFacultyId(String facultyId) {
        List<RequiredSubject> requiredSubject = null;

        try {
            requiredSubject = executeQuery(QUERY_FIND_SUBJECT_ID_BY_FACULTY_ID, new RequiredSubjectRowMapper(), facultyId);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return requiredSubject;
    }
}
