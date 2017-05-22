
package edu.lfa.JDBCExamples.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    public void open() throws ClassNotFoundException, SQLException{
     Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost/ecomm","root", ""); 
    }
    
    public PreparedStatement initStatement(String sql) throws SQLException{
     stmt = conn.prepareStatement(sql);
    return stmt; 
    }
    
    public ResultSet executeQuery() throws SQLException{
            return stmt.executeQuery();
    }
    
    public int executeUpdate() throws SQLException{
          return stmt.executeUpdate();
    }
    
    public void close() throws SQLException{
              if(conn !=null){
              conn.close();
              }
    
    }
}
