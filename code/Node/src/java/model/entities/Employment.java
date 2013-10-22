package model.entities;

import java.util.List;

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
    
    @Override
    public String toString()
    {
        return "{\"employmentId\":"+this.employmetId+",\"name\":\""+this.name+"\"}";
    }
    public static String toJsonArray(List<Employment> array)
    {
        String json = "[";         
        for(Employment employment : array) 
                json += "," + employment.toString();
        return json.replaceFirst(",","")+"]";
    }
}
