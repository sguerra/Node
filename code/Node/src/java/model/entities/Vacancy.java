package model.entities;

import java.util.List;

public class Vacancy implements java.io.Serializable
{
    private int vacancyId;
    private Employment employment;
    private double salary;
    private List<Skill> skills;
    private String description;
    
    public Vacancy()
    {
    }
    
    public void setVacancyId(int vacancyId)
    {
        this.vacancyId = vacancyId;
    }
    public int getVacancyId()
    {
        return vacancyId;
    }
    public void setEmploymet(Employment employment){
        this.employment = employment;
    }
    public Employment getEmployment(){
        return this.employment;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public void setSkills(List<Skill> skills){
        this.skills = skills;
    }
    public List<Skill> getSkills(){
        return this.skills;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}
