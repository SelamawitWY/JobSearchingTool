package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TechnicalInterviewDTO {
    private Date date;
    private String phoneNumber;

    private String email;

    private int applicationId;

    private long duration;

    private LocationEnum location;

    private List<Question> questions;

    public TechnicalInterviewDTO() {
    }

    public TechnicalInterviewDTO(Date date, String phoneNumber, String email, int applicationId,
                                 long duration, LocationEnum location, List<Question> questions) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.applicationId = applicationId;
        this.duration = duration;
        this.location = location;
        this.questions = questions;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public TechnicalInterview getTechnicalInterview(){
        TechnicalInterview interview =  new TechnicalInterview(this.duration ,this.location, this.questions);
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

    public long getDuration() {
        return duration;
    }

    public LocationEnum getLocation() {
        return location;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
