package com.epam.project.dao.interfaces;

import com.epam.project.entity.PointsOnSubject;

import java.util.Optional;

public interface PointsOnSubjectDao extends Dao<PointsOnSubject> {
    Optional<PointsOnSubject> findPointsOnSubjectByPoints(int points);
}
