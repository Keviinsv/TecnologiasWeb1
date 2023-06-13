package managers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserManager {
    private Connection connection;

    public UserManager(Connection connection) {
        this.connection = connection;
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getInt("type"));
                user.setCareerId(resultSet.getInt("career_id"));
                user.setStatus(resultSet.getInt("status"));
                return user;
            }
        }
        
        return null;
    }
    
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getInt("type"));
                user.setCareerId(resultSet.getInt("career_id"));
                user.setStatus(resultSet.getInt("status"));
                users.add(user);
            }
        }
        
        return users;
    }
    
    public boolean createUser(User user) throws SQLException {
        String query = "INSERT INTO user (username, password, type, career_id, status) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, hashPassword(user.getPassword()));
            statement.setInt(3, user.getType());
            statement.setInt(4, user.getCareerId());
            statement.setInt(5, user.getStatus());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE user SET username = ?, password = ?, type = ?, career_id = ?, status = ? WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, hashPassword(user.getPassword()));
            statement.setInt(3, user.getType());
            statement.setInt(4, user.getCareerId());
            statement.setInt(5, user.getStatus());
            statement.setInt(6, user.getId());
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
        }
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return password;
    }
}
