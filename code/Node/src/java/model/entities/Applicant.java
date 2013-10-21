package model.entities;

import java.util.List;

public class Applicant extends User implements java.io.Serializable
{
    private List<Application> applications;
    private List<Skill> skills;
    private List<Vacancy> suggested;
    private List<Vacancy> prospects;
    private String cv;
    
    public Applicant()
    {
        super();
    }
    
    public void setApplications(List<Application> applications)
    {
        this.applications = applications;
    }
    public List<Application> getApplications()
    {
        return this.applications;
    }
    public void setSkills(List<Skill> skills){
        this.skills = skills;
    }
    public List<Skill> getSkills(){
        return this.skills;
    }
    public void setSuggested(List<Vacancy> suggested){
        this.suggested = suggested;
    }
    public List<Vacancy> getSuggested(){
        return this.suggested;
    }
    public void setProspects(List<Vacancy> prospects){
        this.prospects = prospects;
    }
    public List<Vacancy> getProspects(){
        return this.prospects;
    }
}
