
package model;

import java.util.ArrayList;
import java.util.List;
import model.entities.*;

public class DummyObjects 
{
    private static List<User> registered;
    private static List<Skill> skills;
    private static List<Employment> employments;
    
    public static List<User> getRegisteredUsers()
    {
        if(registered!=null)
            return registered;
        
        registered = new ArrayList<User>();
        
        User user = new User();
        user.setUserId(1);
        user.setUserName("applicant");
        user.setName("Sir Aplicante");
        user.setPassword("app");
        user.setDescription("Ing. Sistemas");
        user.setUserType(UserType.applicant);
        user.setEmail("applicant@mail.com");
        
        registered.add(user);
       
        user = new Company();
        user.setUserId(2);
        user.setUserName("company");
        user.setName("Empresa CO");
        user.setPassword("co");
        user.setDescription("Empresa dedicada al desarrollo de Sistemas");
        user.setUserType(UserType.company);
        user.setEmail("company@mail.com");
       
        registered.add(user);
       
        user = new User();
        user.setUserId(3);
        user.setUserName("admin");
        user.setName("Mr. Administrador");
        user.setPassword("admin");
        user.setDescription("Ing. Sistemas también");
        user.setUserType(UserType.admin);
        user.setEmail("admin@mail.com");
        
        registered.add(user);
       
        return registered;
    }
    public static void removeRegisteredUser(User user)
    {
        for(User u : registered)
        {
            if(u.getUserId()==user.getUserId())
            {
                registered.remove(u);
                return;
            }
        }
    }
    public static void addRegisteredUser(User user)
    {
        if(registered==null)
            registered = new ArrayList<User>();
        
        registered.add(user);
    }
    public static void updateRegisteredUser(User user)
    {
        int i = 0;
        for(User u : registered)
        {
            if(u.getUserId()==user.getUserId())
            {
                registered.set(i,user);
                return;
            }
            i++;
        }
    }
    
    public static List<Skill> getSkills()
    {
        if(skills!=null)
            return skills;
            
        skills = new ArrayList<Skill>();
        Skill skill = new Skill();
        skill.setSkillId(1);
        skill.setName("Idioma Ingles");
        skills.add(skill);
        
        skill.setSkillId(2);
        skill.setName("Idioma Alemán");
        skills.add(skill);
        
        skill.setSkillId(3);
        skill.setName("Idioma Francés");
        skills.add(skill);
        
        skill.setSkillId(4);
        skill.setName("Lenguaje Java");
        skills.add(skill);
        
        skill.setSkillId(5);
        skill.setName("Lenguaje C#");
        skills.add(skill);
        
        return skills;
    } 
    public static List<Employment> getEmployments()
    {
        if(employments!=null)
            return employments;
            
        employments = new ArrayList<Employment>();
        
        Employment employment = new Employment();
        employment.setEmploymentId(1);
        employment.setName("Programador");
        employments.add(employment);
        
        employment = new Employment();
        employment.setEmploymentId(2);
        employment.setName("Soporte Técnico");
        employments.add(employment);
        
        employment = new Employment();
        employment.setEmploymentId(3);
        employment.setName("Administrador de Redes");
        employments.add(employment);
        
        employment = new Employment();
        employment.setEmploymentId(4);
        employment.setName("Lider de Poyectos");
        employments.add(employment);
        
        return employments;
    }
}
