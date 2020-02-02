package com.epam.project.builder;

import com.epam.project.entity.RequiredSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequiredSubjectRowMapper implements RowMapper<RequiredSubject> {
    
    @Override
    public RequiredSubject map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(RequiredSubject.ID_COLUMN);
        int facultyId = resultset.getInt(RequiredSubject.FACULTIES_ID_COLUMN);
        int subjectId = resultset.getInt(RequiredSubject.SUBJECT_ID_COLUMN);
        return new RequiredSubject(id, facultyId, subjectId);
    }
}
