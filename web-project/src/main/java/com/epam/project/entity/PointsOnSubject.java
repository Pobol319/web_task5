package com.epam.project.entity;

public class PointsOnSubject implements Identifiable {
    public static final String TABLE = "points_on_subjects";
    public static final String ID_COLUMN = "points_on_subjects_id";
    public static final String NUMBER_OF_POINTS_COLUMN = "number_of_points";
    public static final String STATEMENTS_ID_COLUMN = "statements_statements_id";
    public static final String SUBJECT_ID_COLUMN = "subjects_subject_id";

    private Integer id;
    private int numberOfPoints;
    private int subjectId;
    private int statementId;

    public PointsOnSubject(Integer id, int numberOfPoints, int subjectId, int statementId) {
        this.id = id;
        this.numberOfPoints = numberOfPoints;
        this.subjectId = subjectId;
        this.statementId = statementId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof PointsOnSubject))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        PointsOnSubject pointsOnSubject = (PointsOnSubject) o;

        if (!id.equals(pointsOnSubject.id)) {
            return false;
        }
        if (numberOfPoints != pointsOnSubject.numberOfPoints) {
            return false;
        }
        if (subjectId != pointsOnSubject.subjectId) {
            return false;
        }
        return statementId == pointsOnSubject.statementId;
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + numberOfPoints;
        result = 31 * result + subjectId;
        result = 31 * result + statementId;
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", points=" + numberOfPoints +
                ", subjectNameId=" + subjectId +
                ", statementId=" + statementId +
                '}';
    }

}
