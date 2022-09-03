package miu.cs.cs544.selam.jobsearchingtool.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedNativeQuery(name="Job.getJobWthApplication",
        query="SELECT DISTINCT J.* FROM JOB AS j JOIN APPLICATION AS A ON j.ID = A.JOB_ID",
        resultClass = Job.class)

@NamedNativeQuery(name="Job.getJobWithMoreThan2Interview",
        query="SELECT J.* FROM INTERVIEW AS I " +
                "JOIN APPLICATION AS A ON  I.APPLICATION_ID = A.ID " +
                "JOIN JOB AS J ON J.ID = A.JOB_ID " +
                "GROUP BY JOB_ID having count(*) >=  2",
        resultClass = Job.class)

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version private int version;
    private String title;

    private double salary;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "job")
    @JsonIgnore
    private List<Application> application;

    @OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "JOB_ID")
    private List<Skill> skills;
    
    @ManyToOne(targetEntity = Company.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="COMPANY_ID")
    @JsonIgnore
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Job() {
    }

    public Job(String title, double salary, Company company, List<Skill> skills ) {
        this.title = title;
        this.salary = salary;
        this.skills = skills;
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Application> getApplication() {
        return application;
    }

    public void setApplication(List<Application> application) {
        this.application = application;
    }
}
