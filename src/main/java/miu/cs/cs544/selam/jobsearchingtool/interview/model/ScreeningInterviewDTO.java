package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScreeningInterviewDTO {
    private Date date;
    private String phoneNumber;

    private String email;

    private int applicationId;

    private String name;

    private String result;


    public ScreeningInterviewDTO() {
    }

    public ScreeningInterviewDTO(Date date, String phoneNumber, String email, int applicationId,
                                 String name, String result) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.applicationId = applicationId;
        this.name = name;
        this.result = result;
    }

    public int getApplicationId() {
        return applicationId;
    }


    public ScreeningInterview getScreeningInterview(){
        ScreeningInterview interview =  new ScreeningInterview(this.name, result);
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

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
