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
}
