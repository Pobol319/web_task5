package com.epam.project.command;

import com.epam.project.entity.RequiredSubject;
import com.epam.project.entity.Subject;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.RequiredSubjectService;
import com.epam.project.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

public class GetRequiredSubjects implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/usual/register_to_faculty.jsp";

    RequiredSubjectService requiredSubjectService;
    SubjectService subjectService;

    GetRequiredSubjects(RequiredSubjectService requiredSubjectService, SubjectService subjectService) {
        this.requiredSubjectService = requiredSubjectService;
        this.subjectService = subjectService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("GetRequiredSubjects - done ");

        String facultyId = request.getParameter("facultyId");
        List<RequiredSubject> requiredSubjects = requiredSubjectService.getIdRequiredSubjectByFacultyId(facultyId);
        List<Subject> subjects = new ArrayList<>();
        for (RequiredSubject requiredSubject : requiredSubjects) {
            Long id = requiredSubject.getSubjectId().longValue();
            Optional<Subject> subject = subjectService.findById(id);
            subject.ifPresent(subjects::add);
        }
        request.getSession().setAttribute("requiredSubjects", subjects);
        return CommandResult.forward(PAGE);
    }
}
