
package model.response;

import java.util.HashMap;
import java.util.Map;
import model.petition.Petition;

public class Response 
{
    private Petition petition;
    private Status status;
    private Map<ResponseObject,Object> objects;
    
    
    public Response(Petition petition)
    {
        this.petition = petition;
        this.status = Status.Succes;
        this.objects = new HashMap<ResponseObject,Object>();
    }
    
    public void set(ResponseObject object, Object value)
    {
        this.objects.put(object, value);
    }
    public Object get(ResponseObject object)
    {
        return this.objects.get(object);
    }
    
    public void setStatus(Status status)
    {
        this.status = status;
    }
    public Status getStatus()
    {
        return this.status;
    }
    public Petition getPetition()
    {
        return this.petition;
    }
    
}
