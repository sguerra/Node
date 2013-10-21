package model.entities;

public class Employment implements java.io.Serializable
{
    private int employmetId;
    private String name;
    
    public Employment(){
    }
    
    public void setemploymentId(int employmentId){
        this.employmetId = employmentId;
    }
    
    public int getemployment(){
        return this.employmetId;
    }
    
    public void setname(String name){
        this.name = name;
    }
    
    public String getname(){
        return this.name;
    }
}
