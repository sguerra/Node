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
    
}
