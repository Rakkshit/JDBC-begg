package edu.lfa.JDBCExamples;

import edu.lfa.JDBCExamples.dao.categoryDAO;
import edu.lfa.JDBCExamples.dao.impl.CategoryDAOImpl;
import edu.lfa.JDBCExamples.entity.Category;
import java.sql.SQLException;

public class Management 
{
    public static void main(String[] args) {
    
        try
        {
            categoryDAO catDAO = new CategoryDAOImpl();
            catDAO.insert(new Category(0, "Kitchen", true));
            
        }
        catch(ClassNotFoundException | SQLException ce)
        {
            System.out.println(ce.getMessage());
        }
    }
    
}

