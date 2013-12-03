package controller.backing;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.DataModel;
import model.entities.User;
import model.petition.Entity;
import model.petition.Function;
import model.petition.Petition;
import model.petition.PetitionParam;
import model.response.Response;
import model.response.ResponseObject;
import model.response.Status;

@ManagedBean
@RequestScoped
public class AdminBean 
{
    private DataModel dataModel;
    private List<User> users;
    private User user;

    public AdminBean() 
    {
        this.dataModel = DataModel.getInstance();
                
        this.users = new ArrayList<User>();
        this.user = new User();
    }
    
    public List<User> getUsers() 
    {
        Petition petition = new Petition(Entity.user, Function.get);
        Response response = dataModel.execute(petition);
        
        if(response.getStatus()==Status.Succes)
            users = (List<User>)response.get(ResponseObject.users);
        
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    public void removeAccount(int userId)
    {
        Petition petition = new Petition(Entity.user, Function.delete);
        petition.set(PetitionParam.userId, userId);
        
        Response response  = dataModel.execute(petition);
    }
    
    public void removeSelfAccount(int userId)
    {
        this.removeAccount(userId);
        
        try
        {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            
            context.getExternalContext().redirect("index.xhtml");
        }
        catch(Exception e)
        {
        }
    }
    
    public void addAccount()
    {
        Petition petition = new Petition(Entity.user, Function.add);
        petition.set(PetitionParam.userId, this.GenerateId());
        petition.set(PetitionParam.username, this.user.getUserName());
        petition.set(PetitionParam.userType, this.user.getUserType());
        petition.set(PetitionParam.password, this.user.getPassword());
        petition.set(PetitionParam.email, this.user.getEmail());
        
        Response response  = dataModel.execute(petition);
        
        try
        {
        if(response.getStatus()==Status.Succes)
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
        catch(Exception e)
        {
        }
    }
    
    private int GenerateId()
    {
        double random = Math.random()*10000;
        long rounded = Math.round(random);
        
        int uid = Integer.parseInt(String.valueOf(rounded));
        return uid;
    }
}
