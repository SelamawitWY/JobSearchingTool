package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="I_TYPE")
public abstract class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version private int version;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String phoneNumber;

    private String email;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Application application;

    public Interview() {
    }


    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
