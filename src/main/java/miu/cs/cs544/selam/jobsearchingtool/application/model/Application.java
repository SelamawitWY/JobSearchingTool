package miu.cs.cs544.selam.jobsearchingtool.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.Interview;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version private int version;
    private Date date;

    private int resumeVersion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "JOB_ID") //case sensetive
    private Job job;
    @JsonIgnore
    @OneToMany(targetEntity = Interview.class, cascade = CascadeType.ALL, mappedBy = "application")
    private List<Interview> interviews;

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public int getId() {
        return id;
    }

    public Application() {
    }

    public Application(Date date, int resumeVersion, Job job) {
        this.date = date;
        this.resumeVersion = resumeVersion;
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(int resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Application{" +
                "version=" + version +
                ", date=" + date +
                ", resumeVersion=" + resumeVersion +
                ", job=" + job +
                '}';
    }
}