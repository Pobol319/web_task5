package com.epam.project.connection;


import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.PropertyReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOG = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool instance;
    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionInUse;

    private ReentrantLock connectionsLock = new ReentrantLock();

    private ConnectionPool(){
        availableConnections = new ArrayDeque<>();
        connectionInUse = new ArrayDeque<>();
    }

    public static ConnectionPool getInstance() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();

            if (instance == null) {
                instance = new ConnectionPool();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public void returnConnection(ProxyConnection proxyConnection){
        connectionsLock.lock();
        try {
            if (connectionInUse.contains(proxyConnection)){
                availableConnections.offer(proxyConnection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() throws ConnectionFactoryException {
        return ConnectionFactory.create();
    }
}
