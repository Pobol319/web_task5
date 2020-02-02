package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.interfaces.SubjectDao;
import com.epam.project.entity.Subject;
import com.epam.project.exceptions.ServiceException;

import java.util.Optional;

public class SubjectService {
    private DaoHelperFactory daoHelperFactory;

    public SubjectService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<Subject> findById(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            SubjectDao subjectDao = factory.createSubjectDao();
            return subjectDao.getById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
