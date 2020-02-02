package com.epam.project.command;

import com.epam.project.entity.Faculty;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllFacultiesCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();

    private static final String PAGE = "/view/page/usual/register_to_faculty.jsp";
    private FacultyService service;

    GetAllFacultiesCommand(FacultyService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("GetAllFacultiesCommand - done");

        List<Faculty> allFaculties;
        allFaculties = service.getAllFaculties();
        request.getSession().setAttribute("allFaculties", allFaculties);
        return CommandResult.redirect(PAGE);
    }

}
