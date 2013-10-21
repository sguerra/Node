package model.entities;

public class Skill implements java.io.Serializable
{
    private int skillId;
    private String name;
    
    public Skill(){
    }
    
    public void setskillId(int skillId){
        this.skillId= skillId;
    }
    
    public int getskillId(){
        return this.skillId;
    }
    
    public void setname(String name){
        this.name= name;
    }
    
    public String getname(){
        return this.name;
    }
}
