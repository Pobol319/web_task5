package com.epam.project.entity;

public class Subject implements Identifiable {
    public static final String TABLE = "subjects";
    public static final String ID_COLUMN = "subject_id";
    public static final String NAME_COLUMN = "name";

    private Integer id;
    private SubjectEnum name;

    public Subject(Integer id, SubjectEnum name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public SubjectEnum getName() {
        return name;
    }

    public void setName(SubjectEnum name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Subject subject = (Subject) o;
        if (!id.equals(subject.id)) {
            return false;
        }
        return name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SubjectName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
