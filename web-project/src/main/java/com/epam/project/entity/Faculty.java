package com.epam.project.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements Identifiable {
    public static final String TABLE = "faculties";
    public static final String ID_COLUMN = "faculties_id";
    public static final String MAX_SIZE_COLUMN = "max_size";
    public static final String NAME_COLUMN = "name";

    private Integer id;
    private FacultyEnum name;
    private int maxSize;

    private List<Subject> requiredSubjects;
    private List<User> registeredUsers;

    public Faculty(Integer id, FacultyEnum name, int maxSize) {
        this.id = id;
        this.name = name;
        this.maxSize = maxSize;
        this.requiredSubjects = new ArrayList<>();
        this.registeredUsers = new ArrayList<>();
    }

    public Faculty(Integer id, FacultyEnum name, int maxSize, List<Subject> requiredSubjects) {
        this.id = id;
        this.name = name;
        this.maxSize = maxSize;
        this.requiredSubjects = requiredSubjects;
        this.registeredUsers = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return id;
    }

    public FacultyEnum getName() {
        return name;
    }

    public void setName(FacultyEnum name) {
        this.name = name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(List<Subject> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredEntrants(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSize=" + maxSize +
                ", requiredSubjects=" + requiredSubjects +
                ", registeredUsers=" + registeredUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Faculty))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Faculty faculty = (Faculty) o;

        if (!id.equals(faculty.id)) {
            return false;
        }
        if (maxSize != faculty.maxSize) {
            return false;
        }
        if (!name.equals(faculty.name)) {
            return false;
        }
        if (requiredSubjects != null ? !requiredSubjects.equals(faculty.requiredSubjects) : faculty.requiredSubjects != null) {
            return false;
        }
        return registeredUsers != null ? registeredUsers.equals(faculty.registeredUsers) : faculty.registeredUsers == null;
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + name.hashCode();
        result = 31 * result + maxSize;
        result = 31 * result + (requiredSubjects != null ? requiredSubjects.hashCode() : 0);
        result = 31 * result + (registeredUsers != null ? registeredUsers.hashCode() : 0);
        return result;
    }

}
