package miu.cs.cs544.selam.jobsearchingtool.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class JobDTO  {

    private String title;

    private double salary;

    private List<Skill> skills;

    private int companyId;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public JobDTO() {
    }

    public JobDTO(String title, double salary, List<Skill> skills, int companyId) {
        this.title = title;
        this.salary = salary;
        this.skills = skills;
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public double getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Job getJob(){
        Job job = new Job(title, salary, null, skills);
        return job;
    }
}
