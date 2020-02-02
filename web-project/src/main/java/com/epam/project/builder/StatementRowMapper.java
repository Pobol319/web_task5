package com.epam.project.builder;

import com.epam.project.entity.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StatementRowMapper implements RowMapper<Statement> {

    @Override
    public Statement map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(Statement.ID_COLUMN);
        Date date = resultset.getDate(Statement.DATE_COLUMN);
        int userId = resultset.getInt(Statement.USER_ID_COLUMN);
        int facultyId = resultset.getInt(Statement.FACULTIES_ID_COLUMN);
        return new Statement(id, date, userId, facultyId);
    }
}
