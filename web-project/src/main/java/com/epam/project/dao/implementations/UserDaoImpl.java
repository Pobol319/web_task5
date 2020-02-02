package com.epam.project.dao.implementations;

import com.epam.project.builder.UserRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.interfaces.UserDao;
import com.epam.project.entity.User;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.Optional;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String TABLE = "users";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM users WHERE ID = ?";
    private static final String QUERY_FIND_BY_LOGIN_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";


    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        Optional<User> user = Optional.empty();
        try {
            user = executeForSingleResult(QUERY_FIND_BY_LOGIN_PASSWORD, new UserRowMapper(), login, password);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public void save(User item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
