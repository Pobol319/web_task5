package com.epam.project.dao.interfaces;

import com.epam.project.entity.RequiredSubject;

import java.util.List;
import java.util.Optional;

public interface RequiredSubjectDao extends Dao<RequiredSubject> {
    List<RequiredSubject> findSubjectIdByFacultyId(String facultyId);
}
