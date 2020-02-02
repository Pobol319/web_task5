package com.epam.project.dao;

import com.epam.project.connection.ConnectionPool;
import com.epam.project.connection.ProxyConnection;
import com.epam.project.dao.implementations.*;
import com.epam.project.dao.interfaces.*;
import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.PropertyReaderException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws ConnectionFactoryException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public FacultyDao createFacultyDao() {
        return new FacultyDaoImpl(connection);
    }

    public PointsOnSubjectDao createPointsOnSubjectDao() {
        return new PointsOnSubjectDaoImpl(connection);
    }

    public RequiredSubjectDao createRequiredSubjectDao() {
        return new RequiredSubjectDaoImpl(connection);
    }

    public StatementDao createStatementDao() {
        return new StatementDaoImpl(connection);
    }

    public SubjectDao createSubjectDao() {
        return new SubjectDaoImpl(connection);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
