package com.epam.project.builder;

import com.epam.project.entity.*;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {
    T map(ResultSet resultset) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case User.TABLE:
                return new UserRowMapper();
            case Subject.TABLE:
                return new SubjectRowMapper();
            case Faculty.TABLE:
                return new FacultyRowMapper();
            case PointsOnSubject.TABLE:
                return new PointsOnSubjectRowMapper();
            case RequiredSubject.TABLE:
                return new RequiredSubjectRowMapper();
            case Statement.TABLE:
                return new StatementRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table - " + table);
        }
    }
}
