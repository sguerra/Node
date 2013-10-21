package model.entities;

import java.util.List;

public class Company extends User implements java.io.Serializable
{
    private List<Vacancy> vacancies;
    private List<Applicant> suggested;
    private List<Applicant> prospects;
    
    public Company()
    {
        super();
    }
    
    public void setVacancies(List<Vacancy> vacancies)
    {
        this.vacancies = vacancies;
    }
    public List<Vacancy> getVacancies()
    {
        return this.vacancies;
    }
    public void setSuggested(List<Applicant> suggested){
        this.suggested = suggested;
    }
    public List<Applicant> getSuggested(){
        return this.suggested;
    }
    public void setProspects(List<Applicant> prospects){
        this.prospects = prospects;
    }
    public List<Applicant> getProspects(){
        return this.prospects;
    }
}
