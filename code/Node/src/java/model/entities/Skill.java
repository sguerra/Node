package model.entities;

import java.util.List;

public class Skill implements java.io.Serializable
{
    private int skillId;
    private String name;
    
    public Skill()
    {
    }
    
    public void setSkillId(int skillId)
    {
        this.skillId= skillId;
    }
    public int getSkillId()
    {
        return this.skillId;
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    public String getName(){
        return this.name;
    }
        
    @Override
    public String toString()
    {
        return "{\"skillId\":"+this.skillId+",\"name\":\""+this.name+"}\"";
    }
    public static String toJsonArray(List<Skill> array)
    {
        String json = "[";         
        for(Skill skill : array) 
                json += skill.toString();
        return json+"]";
    }
}
