package miu.cs.cs544.selam.jobsearchingtool.company.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Client")
public class Client extends Company {
    private String mission;
    private String reason;
    private String website;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "clients")
    private List<Recruiter> recruiter;

    public List<Recruiter> getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(List<Recruiter> recruiter) {
        this.recruiter = recruiter;
    }

    public Client() {
    }

    public Client(String mission, String reason, String website) {
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
