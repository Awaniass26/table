package com.core.bd;

import java.sql.*;

public interface Database {
    Object statement = null;
    void OpenConnection();
    void CloseConnection();
    ResultSet executeSelect() throws SQLException;
    int executeUpdate() throws SQLException;
    void initPreparedStatement(String sql) throws SQLException;
} 


