package controller.backing;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.DataModel;
import model.entities.User;
import model.entities.UserType;
import model.petition.Entity;
import model.petition.Function;
import model.petition.Petition;
import model.petition.PetitionParam;
import model.response.Response;
import model.response.ResponseObject;
import model.response.Status;

@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean implements Serializable
{
    private DataModel dataModel;
    // Input
    private String username;
    private String password;
    
    // Output
    private boolean valid;
    private User user;
    
    public SessionBean() 
    {
        this.dataModel = DataModel.getInstance();
        this.user= new User();
    }
    
    // Input
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    
    // Output
    public User getUser() 
    {
        return user;
    }    

    public boolean isValid() 
    {
        return valid;
    }
    
    public void authentify()
    {
        Petition petition = new Petition(Entity.user, Function.login);
        petition.set(PetitionParam.username, this.username);
        petition.set(PetitionParam.password, this.password);
        
        //Dispatch Response
        Response response = dataModel.execute(petition);
        
        if(response.getStatus()==Status.Succes)
        {
            try
            {
                this.user = (User)response.get(ResponseObject.user);
                this.valid = true;
                
                if(user.getUserType()== UserType.admin)
                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
                else
                    FacesContext.getCurrentInstance().getExternalContext().redirect("prospects.xhtml");
                    
            }catch(Exception e)
            {
            }
            
            return;
        }
        
        this.valid = false;
    }
    public void close()
    {
        try
        {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();

            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
        catch(Exception e)
        {
        }
    }
    public void modify()
    {
        Entity entity = this.user.getUserType()==UserType.applicant ? Entity.applicant : Entity.company;
        Petition petition = new Petition(entity, Function.modify);
        
        petition.set(PetitionParam.userId, this.user.getUserId());
        petition.set(PetitionParam.username, this.user.getUserName());
        petition.set(PetitionParam.password, this.user.getPassword());
        petition.set(PetitionParam.userType, this.user.getUserType());
        petition.set(PetitionParam.name, this.user.getName());
        petition.set(PetitionParam.phone, this.user.getPhone());
        petition.set(PetitionParam.age, this.user.getAge());
        petition.set(PetitionParam.address, this.user.getAddress());
        petition.set(PetitionParam.description, this.user.getDescription());
        petition.set(PetitionParam.contact, this.user.getContact());
        petition.set(PetitionParam.email, this.user.getEmail());
        
        Response response = dataModel.execute(petition);
    }
}
