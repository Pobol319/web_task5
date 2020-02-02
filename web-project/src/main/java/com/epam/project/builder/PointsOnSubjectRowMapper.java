package com.epam.project.builder;

import com.epam.project.entity.PointsOnSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PointsOnSubjectRowMapper implements RowMapper<PointsOnSubject> {

    @Override
    public PointsOnSubject map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(PointsOnSubject.ID_COLUMN);
        int numberOfPoints = resultset.getInt(PointsOnSubject.NUMBER_OF_POINTS_COLUMN);
        int subjectId = resultset.getInt(PointsOnSubject.SUBJECT_ID_COLUMN);
        int statementId = resultset.getInt(PointsOnSubject.STATEMENTS_ID_COLUMN);
        return new PointsOnSubject(id, numberOfPoints, subjectId, statementId);
    }
}
