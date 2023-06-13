package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Career;

public class CareerManager {
    private Connection connection;

    public CareerManager(Connection connection) {
        this.connection = connection;
    }

    public List<Career> getAllCareers() throws SQLException {
        List<Career> careers = new ArrayList<>();
        String query = "SELECT * FROM career";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Career career = new Career(); 
                career.setId(resultSet.getInt("id"));
                career.setDescription(resultSet.getString("description"));
                careers.add(career);
            }
        }
        
        return careers;
    }
    
    public Career getCareerById(int id) throws SQLException {
        String query = "SELECT * FROM career WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Career career = new Career();
                career.setId(resultSet.getInt("id"));
                career.setDescription(resultSet.getString("description"));
                return career;
            }
        }
        
        return null;
    }
    
    public boolean createCareer(Career career) throws SQLException {
        String query = "INSERT INTO career (description) VALUES (?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, career.getDescription());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean updateCareer(Career career) throws SQLException {
        String query = "UPDATE career SET description = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, career.getDescription());
            statement.setInt(2, career.getId());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean deleteCareer(int id) throws SQLException {
        String query = "DELETE FROM career WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
}
