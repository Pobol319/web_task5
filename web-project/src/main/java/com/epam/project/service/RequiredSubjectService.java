package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.interfaces.RequiredSubjectDao;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.exceptions.ServiceException;

import java.util.List;

public class RequiredSubjectService {
    private DaoHelperFactory daoHelperFactory;

    public RequiredSubjectService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<RequiredSubject> getIdRequiredSubjectByFacultyId(String facultyId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            RequiredSubjectDao requiredSubjectDao = factory.createRequiredSubjectDao();
            return requiredSubjectDao.findSubjectIdByFacultyId(facultyId);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
