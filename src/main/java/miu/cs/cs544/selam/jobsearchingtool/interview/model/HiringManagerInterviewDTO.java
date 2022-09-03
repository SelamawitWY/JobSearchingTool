package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class HiringManagerInterviewDTO {
    private Date date;
    private String phoneNumber;

    private String email;

    private int applicationId;

    private int teamSize;

    private Date start_date;


    public HiringManagerInterviewDTO() {
    }

    public HiringManagerInterviewDTO(Date date, String phoneNumber, String email, int applicationId,
                                    int teamSize, Date start_date) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.applicationId = applicationId;
        this.teamSize = teamSize;
        this.start_date = start_date;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public HiringManagerInterview getHiringManagerInterview(){
        HiringManagerInterview interview =  new HiringManagerInterview(teamSize,start_date);
        interview.setDate(date);
        interview.setEmail(email);
        interview.setPhoneNumber(phoneNumber);

        return interview;
    }

    public Date getDate() {
        return date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public Date getStart_date() {
        return start_date;
    }
}
