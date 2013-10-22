
package model;

import java.util.ArrayList;
import java.util.List;
import model.entities.*;

public class DummyObjects 
{
    private static List<User> registered;
    
    public static List<User> getRegisteredUsers()
    {
        if(registered!=null)
            return registered;
        
        registered = new ArrayList<User>();
        
        User user = new User();
        user.setUserName("applicant");
        user.setName("Señor Aplicante");
        user.setPassword("app");
        user.setDescription("Ing. Sistemas");
        user.setUserType(UserType.applicant);
        user.setEmail("applicant@mail.com");
        
        registered.add(user);
       
        user = new User();
        user.setUserName("company");
        user.setName("Empresa CO");
        user.setPassword("co");
        user.setDescription("Empresa dedicada al desarrollo de Sistemas");
        user.setUserType(UserType.company);
        user.setEmail("company@mail.com");
       
        registered.add(user);
       
        user = new User();
        user.setUserName("admin");
        user.setName("Mr. Administrador");
        user.setPassword("admin");
        user.setDescription("Ing. Sistemas también");
        user.setUserType(UserType.admin);
        user.setEmail("admin@mail.com");
        
        registered.add(user);
       
        return registered;
    }
}
