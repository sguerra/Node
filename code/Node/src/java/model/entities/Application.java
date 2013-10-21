package model.entities;

public class Application implements java.io.Serializable
{
    private int applicationId;
    private Employment employment;
    private double salary;
    private String description;
    
    public Application()
    {
    }
    
    public void setApplicationId(int applicationId)
    {
        this.applicationId = applicationId;
    }
    public int getApplicationId()
    {
        return this.applicationId;
    }
    public void setEmployment(Employment employment){
        this.employment = employment;
    }
    public Employment getEmployment(){
        return this.employment;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public void serDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    
}
