package com.epam.project.____;

import com.epam.project.connection.ConnectionPool;
import com.epam.project.dao.implementations.FacultyDaoImpl;
import com.epam.project.dao.implementations.RequiredSubjectDaoImpl;
import com.epam.project.dao.implementations.SubjectDaoImpl;
import com.epam.project.dao.implementations.UserDaoImpl;
import com.epam.project.entity.Faculty;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.entity.Subject;
import com.epam.project.entity.User;
import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.DaoException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws ConnectionFactoryException, DaoException {
       /* Connection connection = ConnectionFactory.create();

        PreparedStatement prState = connection.prepareStatement("SELECT * FROM USERS WHERE user_id = 1 ");
        ResultSet resultset = prState.executeQuery();

        while (resultset.next()){
            System.out.println(resultset.getString("name"));
        }

        System.out.println(resultset.toString());*/


        ConnectionPool pool = ConnectionPool.getInstance();
       /* SubjectDaoImpl subjectDao = new SubjectDaoImpl(pool.getConnection());
        List<Subject> subjects = subjectDao.getAll();
        System.out.println(subjects.size());
        for (Subject subject : subjects) {
            System.out.println(subject.toString());
        }*/

        UserDaoImpl userDao = new UserDaoImpl(pool.getConnection());
        Optional<User> user = userDao.findUserByLoginAndPassword("ppobol", "qwe123");

        FacultyDaoImpl facultyDao = new FacultyDaoImpl(pool.getConnection());
        List<Faculty> faculties = facultyDao.getAll();

        RequiredSubjectDaoImpl requiredSubjectDao = new RequiredSubjectDaoImpl(pool.getConnection());
        List<RequiredSubject> requiredSubjects = requiredSubjectDao.findSubjectIdByFacultyId("3");

        SubjectDaoImpl subjectDao = new SubjectDaoImpl(pool.getConnection());

       /*for (RequiredSubject requiredSubject1 : requiredSubjects){
            System.out.println(requiredSubject1.toString());
        }*/

        List<Subject> subjects = new ArrayList<>();
        for (RequiredSubject requiredSubject: requiredSubjects){
            Long id =  requiredSubject.getSubjectId().longValue();
            Optional<Subject> optionalSubject = subjectDao.getById(id);
            optionalSubject.ifPresent(subjects::add);
        }

        for(Subject subject : subjects){
            System.out.println(subject.toString());
        }

    }


}
