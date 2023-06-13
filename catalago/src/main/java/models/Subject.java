package models;

public class Subject {
    private int id;
    private String description;
    private int careerId;
    
    public Subject(int id, String description, int careerId) {
        this.id = id;
        this.description = description;
        this.careerId = careerId;
    }
    
    public Subject(){
        
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getCareerId() {
        return careerId;
    }
    
    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }
}


