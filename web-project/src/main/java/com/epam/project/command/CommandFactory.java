package com.epam.project.command;

import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.service.FacultyService;
import com.epam.project.service.RequiredSubjectService;
import com.epam.project.service.SubjectService;
import com.epam.project.service.UserService;

public class CommandFactory {

    public static Command create(String command) {
        switch (command) {
            case "authorize":
                return new AuthorizeCommand(new UserService(new DaoHelperFactory()));
            case "register_to_faculty":
                return new GetAllFacultiesCommand(new FacultyService(new DaoHelperFactory()));
            case "get_required_subjects":
                return new GetRequiredSubjects(new RequiredSubjectService(new DaoHelperFactory()),
                        new SubjectService(new DaoHelperFactory()));
            case "choose_language":
                return new ChooseLanguageCommand();
            case "logout":
                return new LogoutCommand();
            default:
                throw new IllegalArgumentException("unknown command");
        }
    }

}
