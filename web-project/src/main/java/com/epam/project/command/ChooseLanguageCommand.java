package com.epam.project.command;

import com.epam.project.entity.User;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.page.Language;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChooseLanguageCommand implements Command {
    private static final String PAGE = "/view/page/usual/menu.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String langStr = request.getParameter("language");
        Language language = Language.valueOf(langStr.toUpperCase());

        HttpSession session = request.getSession();
        session.setAttribute("locale", language.getLocale());

        return CommandResult.forward(PAGE);
    }

}
