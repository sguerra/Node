package model.petition;
import java.util.HashMap;
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
        this.params = new HashMap<PetitionParam, Object>();
    }
    
    public void setParams(Map<PetitionParam,Object> params)
    {
        this.params = params;
    }
    public Object set(PetitionParam param, Object value)
    {
        return this.params.put(param, value);
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
