
package edu.lfa.JDBCExamples.dao;
import edu.lfa.JDBCExamples.entity.Category;
import java.sql.SQLException;
import java.util.List;
public interface categoryDAO {
    int insert(Category c) throws ClassNotFoundException, SQLException;
    int update(Category c) throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException, SQLException;
    Category getById(int id) throws ClassNotFoundException, SQLException;
    List<Category> getAll()  throws ClassNotFoundException, SQLException;
}
