package com.epam.project.command;



import com.epam.project.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(HttpServletRequest request,HttpServletResponse response) throws ServiceException;
}
