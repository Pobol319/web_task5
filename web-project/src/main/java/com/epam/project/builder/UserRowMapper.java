package com.epam.project.builder;

import com.epam.project.entity.UserRoleEnum;
import com.epam.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(User.ID_COLUMN);
        String name = resultset.getString(User.NAME_COLUMN);
        String login = resultset.getString(User.LOGIN_COLUMN);
        String password = resultset.getString(User.PASSWORD_COLUMN);
        String roleString = resultset.getString(User.ROLE_COLUMN);
        UserRoleEnum userRoleEnum = UserRoleEnum.valueOf(roleString);
        return new User(id, name, login, password, userRoleEnum);
    }
}
