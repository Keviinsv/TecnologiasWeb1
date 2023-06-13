package models;

public class User {
    private int id;
    private String username;
    private String password;
    private int type;
    private int careerId;
    private int status;
    
    public User(int id, String username, String password, int type, int careerId, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.careerId = careerId;
        this.status = status;
    }
    public User(){

    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getCareerId() {
        return careerId;
    }
    
    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
}



