package model.petition;
import model.petition.Function;
import model.petition.Entity;
import java.util.Map;

public class Petition 
{
    private Entity entity;
    private Function function;
    private Map<PetitionParam,Object> params;
    
    public Petition(Entity entity, Function function)
    {
        this.entity = entity;
        this.function = function;
    }
    
    public void setParams(Map<PetitionParam,Object> params)
    {
        this.params = params;
    }
    public Object get(PetitionParam param)
    {
        return this.params.get(param);
    }
    
    public Entity getEntity()
    {
        return this.entity;
    }
    public Function getFunction()
    {
        return this.function;
    }
}
