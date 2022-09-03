package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("Hiring-I")
public class HiringManagerInterview extends Interview {
    private int teamSize;
    private Date start_date;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(int teamSize, Date start_date) {
        this.teamSize = teamSize;
        this.start_date = start_date;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
