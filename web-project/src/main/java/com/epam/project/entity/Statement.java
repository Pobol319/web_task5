package com.epam.project.entity;

import java.util.Date;

public class Statement implements Identifiable {
    public static final String TABLE = "statements";
    public static final String ID_COLUMN = "statements_id";
    public static final String DATE_COLUMN = "date";
    public static final String FACULTIES_ID_COLUMN = "faculties_faculties_id";
    public static final String USER_ID_COLUMN = "users_user_id";

    private Integer id;
    private Date date;
    private int userId;
    private int facultyId;

    public Statement(Integer id, Date date, int userId, int facultyId) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.facultyId = facultyId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", date=" + date +
                ", userId='" + userId + '\'' +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Statement))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Statement statement = (Statement) o;

        if (!id.equals(statement.id)) {
            return false;
        }
        if (date != null ? !date.equals(statement.date) : statement.date != null) {
            return false;
        }
        if (!(userId == statement.userId)) {
            return false;
        }
        return facultyId == statement.facultyId;
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + facultyId;
        return result;
    }

}
