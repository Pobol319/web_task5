package com.epam.project.builder;

import com.epam.project.entity.Faculty;
import com.epam.project.entity.FacultyEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyRowMapper implements RowMapper<Faculty> {
    @Override
    public Faculty map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(Faculty.ID_COLUMN);
        int maxSize = resultset.getInt(Faculty.MAX_SIZE_COLUMN);
        String name = resultset.getString(Faculty.NAME_COLUMN);
        FacultyEnum nameEnum = FacultyEnum.valueOf(name);
        return new Faculty(id, nameEnum, maxSize);
    }
}
