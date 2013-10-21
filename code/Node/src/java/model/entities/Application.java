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
    
}
