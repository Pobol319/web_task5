package com.epam.project.dao.interfaces;

import com.epam.project.entity.Subject;

import java.util.Optional;

public interface SubjectDao extends Dao<Subject> {
    Optional<Subject> findSubjectByName(String name);
}
