package miu.cs.cs544.selam.jobsearchingtool.application.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationDTO {
    private Date date;

    private int resumeVersion;

    private int  jobId;

    public ApplicationDTO() {

    }

    public ApplicationDTO(Date date, int resumeVersion, int jobId) {
        this.date = date;
        this.resumeVersion = resumeVersion;
        this.jobId = jobId;
    }

    public Date getDate() {
        return date;
    }

    public int getResumeVersion() {
        return resumeVersion;
    }


    public Application getApplication(){
        Application application =  new Application();
        application.setDate(date);
        application.setResumeVersion(resumeVersion);

        return application;
    }


    public int getJobId() {
        return jobId;
    }
}
