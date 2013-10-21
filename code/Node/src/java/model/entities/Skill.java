package model.entities;

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
}
