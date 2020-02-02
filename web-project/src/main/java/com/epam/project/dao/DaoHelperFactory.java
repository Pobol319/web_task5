package com.epam.project.dao;

import com.epam.project.connection.ConnectionPool;
import com.epam.project.exceptions.ConnectionFactoryException;


public class DaoHelperFactory implements AutoCloseable {
    public DaoHelper create() throws ConnectionFactoryException {
        return new DaoHelper(ConnectionPool.getInstance());
    }

    @Override
    public void close() throws Exception {

    }
}
