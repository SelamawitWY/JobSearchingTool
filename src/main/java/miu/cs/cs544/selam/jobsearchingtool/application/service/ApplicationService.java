package miu.cs.cs544.selam.jobsearchingtool.application.service;

import miu.cs.cs544.selam.jobsearchingtool.application.JMS.ApplicationSender;
import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.model.ApplicationDTO;
import miu.cs.cs544.selam.jobsearchingtool.application.repository.ApplicationRepository;
import miu.cs.cs544.selam.jobsearchingtool.exception.NotFoundException;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.LanguageEnum;
import miu.cs.cs544.selam.jobsearchingtool.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ApplicationService implements ErrorHandler {

    private Logger logger;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    JobService jobService;

    @Autowired
    ApplicationSender applicationSender;

    @JmsListener(destination = "${springjms.cs544FinalBroker}")//, containerFactory = "myFactory")
    public void receive(Map data){

        if(data.get("response") != null){
            System.out.println("Response from application service received, Confirmed!");

        } else if(data.get("request") != null && data.get("method") != null){
            String method = data.get("method").toString();
            System.out.println(data.get("method") + " request for application received");

            if(method.compareTo(RequestMethod.GET.name()) == 0){
                this.getApplication(true);
            } else if(method.compareTo(RequestMethod.POST.name()) == 0){
                Application application = new Application(
                        new Date(Long.parseLong(data.get("data.date").toString())),
                        Integer.parseInt(data.get("data.resumeVersion").toString()), null);

                this.addApplication(Integer.parseInt(data.get("data.jobId").toString()), application);
            } else if(method.compareTo(RequestMethod.PUT.name()) == 0){
                Application application = new Application(
                        new Date(Long.parseLong(data.get("data.date").toString())),
                        Integer.parseInt(data.get("data.resumeVersion").toString()), null);

                this.updateApplication(Integer.parseInt(data.get("id").toString()),
                        Integer.parseInt(data.get("data.jobId").toString()), application);
            } else if(method.compareTo(RequestMethod.DELETE.name()) == 0){
                this.deleteApplication(Integer.parseInt(data.get("id").toString()));
            }

        }
    }

    public Application addApplication(int jobID, Application application){
        Job job = this.jobService.getJobById(jobID);
        application.setJob(job);

        Application savedApplication = this.applicationRepository.save(application);
        return savedApplication;
    }

    public List<Application> getApplication(boolean isJms){
        if(isJms) applicationSender.responseSender(this.applicationRepository.findAll()) ;
        return this.applicationRepository.findAll();
    }


    public Application updateApplication(int id, int jobID, Application application){
        Application currentApplication = this.getByID(id);
        currentApplication.setResumeVersion(application.getResumeVersion());
        currentApplication.setDate(application.getDate());

        Job job = this.jobService.getJobById(jobID);
        currentApplication.setJob(job);

        Application updatedApplication = this.applicationRepository.save(currentApplication);
        return updatedApplication;
    }

    public void deleteApplication(int id){
        Application application = this.getByID(id);
        this.applicationRepository.deleteById(application.getId());
    }

    public Application getByID(int id){
        Optional<Application> application = this.applicationRepository.findById(id);
        if(application.isPresent()){
            return application.get();
        } else {
            throw new NotFoundException("Application with id "+ id + " not found");
        }
    }

    public List<Application> getByJobSkill(LanguageEnum language){
        return this.applicationRepository.getByJobSkill(language.name());
    }

    public List<Application> findApplicationBySalary(double salary){
        return this.applicationRepository.findApplicationBySalary(salary);
    }

    public List<Application> findAllByJob_CompanyId(int id){
        return this.applicationRepository.findAllByJob_CompanyId(id);
    }

    @Override
    public void handleError(Throwable t) {
        logger.info("In default jms error handler...");
        logger.exiting("Error Message : {}", t.getMessage());
    }
}
