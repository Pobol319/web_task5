package com.epam.project.builder;

import com.epam.project.entity.Subject;
import com.epam.project.entity.SubjectEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectRowMapper implements RowMapper<Subject> {

    @Override
    public Subject map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(Subject.ID_COLUMN);
        String nameString = resultset.getString(Subject.NAME_COLUMN);
        if (nameString.equals("Russian language")) {
            nameString = "Russian_language";
        }
        SubjectEnum nameEnum = SubjectEnum.valueOf(nameString.toUpperCase());
        return new Subject(id, nameEnum);
    }
}
