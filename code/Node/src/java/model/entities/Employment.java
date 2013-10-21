package model.entities;

public class Employment implements java.io.Serializable
{
    private int employmetId;
    private String name;
    
    public Employment(){
    }
    
    public void setEmploymentId(int employmentId)
    {
        this.employmetId = employmentId;
    }
    public int getEmployment()
    {
        return this.employmetId;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
}
