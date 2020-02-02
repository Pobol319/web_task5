package com.epam.project.entity;

import java.util.ArrayList;
import java.util.List;

public class User implements Identifiable {
    public static final String TABLE = "users";
    public static final String ID_COLUMN = "user_id";
    public static final String NAME_COLUMN = "name";
    public static final String LOGIN_COLUMN = "login";
    public static final String PASSWORD_COLUMN = "password";
    public static final String ROLE_COLUMN = "role";

    private Integer id;
    private String name;
    private String login;
    private String password;
    private UserRoleEnum role;

    private List<Statement> statements;

    public User(Integer id, String name, String login, String password, UserRoleEnum role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.statements = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof User))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        User user = (User) o;

        if (!id.equals(user.id)) {
            return false;
        }
        if (!name.equals(user.name)) {
            return false;
        }
        if (!login.equals(user.login)) {
            return false;
        }
        if (!password.equals(user.password)) {
            return false;
        }
        if (!role.equals(user.role)) {
            return false;
        }
        return statements != null ? statements.equals(user.statements) : user.statements == null;
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (statements != null ? statements.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", subjects=" + statements +
                '}';
    }
}
