package controller.backing;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.DataModel;
import model.entities.Applicant;
import model.entities.Vacancy;
import model.petition.Entity;
import model.petition.Function;
import model.petition.Petition;
import model.petition.PetitionParam;
import model.response.Response;
import model.response.ResponseObject;
import model.response.Status;

@ManagedBean
@RequestScoped
public class MatchBean 
{
    private DataModel dataModel;
    
    public MatchBean() 
    {
        this.dataModel = DataModel.getInstance();
    }
    
    public List<Vacancy> suggestedVacancies(int userId)
    {
        List<Vacancy> suggested = new ArrayList<Vacancy>();
        
        Petition petition = new Petition(Entity.applicant, Function.suggest);
        petition.set(PetitionParam.userId, userId);
        
        Response response = dataModel.execute(petition);
        
        if(response.getStatus() == Status.Succes)
            suggested = (List<Vacancy>)response.get(ResponseObject.vacancies);
        
        return suggested;
    }
    public List<Applicant> suggestedApplicants(int userId)
    {
        List<Applicant> suggested = new ArrayList<Applicant>();
        
        Petition petition = new Petition(Entity.company, Function.suggest);
        petition.set(PetitionParam.userId, userId);
        
        Response response = dataModel.execute(petition);
        
        if(response.getStatus() == Status.Succes)
            suggested = (List<Applicant>)response.get(ResponseObject.applicants);
        
        return suggested;
    }
}
