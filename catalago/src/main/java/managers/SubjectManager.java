package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Subject;

public class SubjectManager {
    private Connection connection;

    public SubjectManager(Connection connection) {
        this.connection = connection;
    }

    public List<Subject> getSubjectsByCareerId(int careerId) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM subject WHERE career_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, careerId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setDescription(resultSet.getString("description"));
                subject.setCareerId(resultSet.getInt("career_id"));
                subjects.add(subject);
            }
        }
        
        return subjects;
    }
    
    public Subject getSubjectById(int id) throws SQLException {
        String query = "SELECT * FROM subject WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setDescription(resultSet.getString("description"));
                subject.setCareerId(resultSet.getInt("career_id"));
                return subject;
            }
        }
        
        return null;
    }
    
    public boolean createSubject(Subject subject) throws SQLException {
        String query = "INSERT INTO subject (description, career_id) VALUES (?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subject.getDescription());
            statement.setInt(2, subject.getCareerId());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean updateSubject(Subject subject) throws SQLException {
        String query = "UPDATE subject SET description = ?, career_id = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subject.getDescription());
            statement.setInt(2, subject.getCareerId());
            statement.setInt(3, subject.getId());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean deleteSubject(int id) throws SQLException {
        String query = "DELETE FROM subject WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
}

