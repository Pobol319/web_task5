package com.epam.project.dao.interfaces;

import com.epam.project.entity.User;
import com.epam.project.exceptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login,String password);
}
