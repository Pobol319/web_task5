package com.epam.project.command;

import com.epam.project.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String PAGE = "/view/page/general/authorization.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        session.invalidate();
        return CommandResult.redirect(PAGE);
    }
}
