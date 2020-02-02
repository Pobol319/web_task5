package com.epam.project.dao.interfaces;

import com.epam.project.entity.Faculty;
import com.epam.project.entity.FacultyEnum;

import java.util.Optional;

public interface FacultyDao extends Dao<Faculty> {
    Optional<Faculty> findFacultyByName(FacultyEnum name);
}
