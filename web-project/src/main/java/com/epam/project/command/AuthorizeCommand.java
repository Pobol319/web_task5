package com.epam.project.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.entity.User;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AuthorizeCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();

    private static final String PAGE = "/view/page/usual/menu.jsp";
    private UserService service;

    public AuthorizeCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("AuthorizeCommand - done ");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = service.login(login, password);
        user.ifPresent(u -> request.getSession().setAttribute("user", u));
        return CommandResult.redirect(PAGE);
    }
}
