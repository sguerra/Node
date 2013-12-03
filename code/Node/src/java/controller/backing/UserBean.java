
package controller.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.entities.User;

@ManagedBean
@SessionScoped
public class UserBean 
{
    private User user;

    public UserBean() 
    {
        user = new User();
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    public void modifyUser()
    {
        
    }
    
}
