package model;

import java.util.ArrayList;
import java.util.List;
import model.entities.Applicant;
import model.entities.Company;
import model.entities.Employment;
import model.entities.Skill;
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
                
                if(petition.getEntity()==Entity.user)
                    response.set(ResponseObject.user, loginUser(petition));
                
                break;
            case add:
                
                if(petition.getEntity()==Entity.user)
                    response.set(ResponseObject.user, addUser(petition));
                
                break;
            case apply:
                break;
            case delete:
                
                if(petition.getEntity()==Entity.user)
                    response.set(ResponseObject.user, deleteUser(petition));
                
                break;
            case modify:
                
                if(petition.getEntity()==Entity.applicant)
                    response.set(ResponseObject.applicant, modifyApplicant(petition));
                if(petition.getEntity()==Entity.company)
                    response.set(ResponseObject.company, modifyCompany(petition));
                
                break;
            case logout:
                
                if(petition.getEntity()==Entity.user)
                    response.set(ResponseObject.user, logoutUser(petition));
                
                break;
            case get:
                
                if(petition.getEntity()==Entity.skill)
                    response.set(ResponseObject.skills, getSkill(petition));
                if(petition.getEntity()==Entity.employment)
                    response.set(ResponseObject.skills, getEmployment(petition));
                
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
        
        user.setUserName(petition.get(PetitionParam.username).toString());
        user.setUserType( UserType.get(petition.get(PetitionParam.userType).toString()));
        user.setPassword(petition.get(PetitionParam.password).toString());
        user.setEmail(petition.get(PetitionParam.email).toString());
        
        return user;
    }
    private User loginUser(Petition petition)
    {
        String username = petition.get(PetitionParam.username).toString();
        User user = new User();
        
        user.setUserName(username);
        user.setPassword(petition.get(PetitionParam.password).toString());
        
        if(username.equals("applicant"))
        {
            user.setName("Señor Aplicante");
            user.setDescription("Ing. Sistemas");
            user.setUserType(UserType.applicant);
            user.setEmail("applicant@mail.com");
        }
        else if(username.equals("company"))
        {
            user.setName("Empresa CO");
            user.setDescription("Empresa dedicada al desarrollo de Sistemas");
            user.setUserType(UserType.company);
            user.setEmail("company@mail.com");
            
        }else if(username.equals("admin"))
        {
            user.setName("Mr. Administrador");
            user.setDescription("Ing. Sistemas también");
            user.setUserType(UserType.admin);
            user.setEmail("admin@mail.com");
        }
        
        return user;
    }
    private User logoutUser(Petition petition)
    {
        User user = new User();
        return user;
    }
    private User deleteUser(Petition petition)
    {
        User user = new User();
        return user;
    }

    private Applicant modifyApplicant(Petition petition)
    {
        Applicant applicant = new Applicant();
        
        applicant.setName(petition.get(PetitionParam.name).toString());
        applicant.setPhone(petition.get(PetitionParam.phone).toString());
        applicant.setAddress(petition.get(PetitionParam.address).toString());
        applicant.setDescription(petition.get(PetitionParam.description).toString());
        applicant.setContact(petition.get(PetitionParam.contact).toString());
        
        return applicant;
    }
    private Company modifyCompany(Petition petition)
    {
        Company company = new Company();
        
        company.setName(petition.get(PetitionParam.name).toString());
        company.setPhone(petition.get(PetitionParam.phone).toString());
        company.setAddress(petition.get(PetitionParam.address).toString());
        company.setDescription(petition.get(PetitionParam.description).toString());
        company.setContact(petition.get(PetitionParam.contact).toString());
        
        return company;
    }
    
    private String getSkill(Petition petition)
    {
        List<Skill> skills = new ArrayList<Skill>();
        
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
        
        return Skill.toJsonArray(skills);
    }
    
    private String getEmployment(Petition petition)
    {
        List<Employment> employments = new ArrayList<Employment>();
        
        Employment employment = new Employment();
        
        employment.setEmploymentId(1);
        employment.setName("Programador");
        
        employment.setEmploymentId(2);
        employment.setName("Soporte Técnico");
        
        employment.setEmploymentId(3);
        employment.setName("Administrador de Redes");
        
        employment.setEmploymentId(4);
        employment.setName("Lider de Poyectos");
        
        return Employment.toJsonArray(employments);
    }
    
    
}
