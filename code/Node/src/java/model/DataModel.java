package model;

import model.entities.User;
import model.entities.UserType;
import model.petition.Entity;
import model.petition.Petition;
import model.petition.PetitionParam;
import model.response.Response;
import model.response.ResponseObject;
import model.response.Status;

public class DataModel 
{
    private static DataModel dataModel;
    
    private DataModel()
    {
    }
    public static DataModel getInstance()
    {
        if(dataModel == null)
            dataModel = new DataModel();
        
        return dataModel;
    }
    
    
    public Response execute(Petition petition)
    {
        Response response = new Response(petition);
        
        switch(petition.getFunction())
        {
            case login:
                break;
            case add:
                if(petition.getEntity()==Entity.user)
                    response.set(ResponseObject.user, addUser(petition));
                break;
            case apply:
                break;
            case delete:
                break;
            case modify:
                break;
            case logout:
                break;
            case get:
                break;
            default:
                response.setStatus(Status.PetitionNotFound);
                break;
        }
        
        return response;
    }
    
    private User addUser(Petition petition)
    {
        User user = new User();
        
        user.setName(petition.get(PetitionParam.name).toString());
        user.setUserType( UserType.get(petition.get(PetitionParam.userType).toString()));
        user.setPassword(petition.get(PetitionParam.password).toString());
        user.setEmail(petition.get(PetitionParam.email).toString());
        
        return user;
    }
}
