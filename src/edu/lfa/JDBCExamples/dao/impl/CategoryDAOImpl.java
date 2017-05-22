
package edu.lfa.JDBCExamples.dao.impl;

import edu.lfa.JDBCExamples.dao.categoryDAO;
import edu.lfa.JDBCExamples.dbUtil.DBConnection;
import edu.lfa.JDBCExamples.entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAOImpl implements categoryDAO{
    private DBConnection dbcon = new DBConnection();
    private List<Category> catlist = new ArrayList<>();
    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
       Category cat = new Category();
        dbcon.open();
            
            String sql = "Insert into tbl_categories (name,status) values (?,?)";
            PreparedStatement stmt = dbcon.initStatement(sql);
            
            stmt.setString(1,c.getName());
            stmt.setBoolean(2,c.isStatus());
            int rs = dbcon.executeUpdate();
            
            if(rs>0){
                System.out.println("Inserted!");
            }
            dbcon.close();
            return rs;
    }

    @Override
    public int update(Category c) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
        dbcon.open();
            Category cat = new Category();
            String sql = "Select * from tbl_categories where cat_id = ?";
            PreparedStatement stmt = dbcon.initStatement(sql);
            stmt.setInt(1,id);
            
            ResultSet rs = dbcon.executeQuery();
            
            while(rs.next()){
                cat.setId(rs.getInt("cat_id"));
                cat.setName(rs.getString("name"));
                cat.setStatus(rs.getBoolean("status"));
            }
            dbcon.close();
            return cat;
    }

    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        
        dbcon.open();
            
            String sql = "Select * from tbl_categories";
            PreparedStatement stmt = dbcon.initStatement(sql);
            
            
            ResultSet rs = dbcon.executeQuery();
            
            while(rs.next()){
                Category cat = new Category();
                cat.setId(rs.getInt("cat_id"));
                cat.setName(rs.getString("name"));
                cat.setStatus(rs.getBoolean("status"));
                catlist.add(cat);
                
            }
            dbcon.close();
            return catlist;
    }
    
}
