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
    
}
