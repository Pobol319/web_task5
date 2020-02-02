package com.epam.project;

import com.epam.project.command.Command;
import com.epam.project.command.CommandFactory;
import com.epam.project.command.CommandResult;
import com.epam.project.exceptions.ServiceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Controller extends HttpServlet {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String ERROR_PAGE = "/view/page/usual/error.jsp";

    @Override
    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("doGet - done");
        processRequest(req, resp);
        System.out.println(req.getAttribute("loc"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("doPost - done");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        CommandResult commandResult;
        try {
            String commandName = req.getParameter("command");
            Command command = CommandFactory.create(commandName);
            commandResult = command.execute(req, resp);
        } catch (ServiceException e) {
            session.setAttribute("errorMessage", e);
            commandResult = CommandResult.forward(ERROR_PAGE);
        } catch (Exception e) {
            session.setAttribute("errorMessage", e);
            commandResult = CommandResult.forward(ERROR_PAGE);
        }

        dispatch(req, resp, commandResult);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, CommandResult commandResult
    ) throws ServletException, IOException {
        LOG.info(commandResult.getPage());
        if(!commandResult.isRedirect()){
            LOG.info("command forward - done");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(commandResult.getPage());
            requestDispatcher.forward(req, resp);
        } else {
            LOG.info("command redirect - done");
            String url = req.getContextPath() + commandResult.getPage();
            resp.sendRedirect(url);
        }
    }

}
