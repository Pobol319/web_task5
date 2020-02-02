package com.epam.project.dao.interfaces;

import com.epam.project.entity.Statement;

import java.util.Date;
import java.util.Optional;

public interface StatementDao extends Dao<Statement> {
    Optional<Statement> findStatementByDate(Date date);
}
